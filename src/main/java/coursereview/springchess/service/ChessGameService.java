package coursereview.springchess.service;

import coursereview.springchess.controller.dto.GameInfoDto;
import coursereview.springchess.controller.dto.WinnerDto;
import coursereview.springchess.domain.ChessGameRepository;
import coursereview.springchess.domain.PieceRepository;
import coursereview.springchess.domain.board.Board;
import coursereview.springchess.domain.board.DefaultPieceInitializer;
import coursereview.springchess.domain.board.PieceManager;
import coursereview.springchess.domain.game.ChessGame;
import coursereview.springchess.domain.piece.Piece;
import coursereview.springchess.domain.piece.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static coursereview.springchess.domain.common.Color.BLACK;
import static coursereview.springchess.domain.common.Color.WHITE;
import static coursereview.springchess.domain.game.GameStatus.BATTLE;

@Service
public class ChessGameService {

    private static final Logger log = LoggerFactory.getLogger(ChessGameService.class);

    private final ChessGameRepository chessGameRepository;
    private final PieceRepository pieceRepository;

    private static Long currentGameId;

    private final PieceManager pieceManager = new PieceManager(new DefaultPieceInitializer());

    @Autowired
    public ChessGameService(final ChessGameRepository chessGameRepository, final PieceRepository pieceRepository) {
        this.chessGameRepository = chessGameRepository;
        this.pieceRepository = pieceRepository;
    }

    public GameInfoDto initialize() {
        ChessGame chessGame = new ChessGame();
        ChessGame savedChessGame = chessGameRepository.save(chessGame);
        currentGameId = savedChessGame.getId();
        List<Piece> pieces = pieceManager.initializePieces(savedChessGame.getId());
        List<Piece> savedPieces = pieceRepository.saveAll(pieces);
        return new GameInfoDto(chessGame.getTurn(), chessGame.getScoreWhite(), chessGame.getScoreBlack(),
                chessGame.getGameStatus(), savedPieces);
    }

    public Map<String, List<String>> calculateMovablePositions() {
        ChessGame chessGame = chessGameRepository.findById(currentGameId)
                .orElseThrow(() -> new IllegalArgumentException("게임을 다시 시작해주세요."));
        List<Piece> pieces = pieceRepository.findAllByGameId(currentGameId);

        Board board = new Board(pieces);

        return board.calculateMovablePositions(chessGame.getTurn()).entrySet().stream()
                .collect(Collectors.toMap(
                        entry -> convertToWebFormat(entry.getKey()),
                        entry -> entry.getValue().stream()
                                .map(this::convertToWebFormat)
                                .collect(Collectors.toList())));
    }

    private String convertToWebFormat(Position position) {
        return position.getColumn().getColumn() + position.getRow().getRow();
    }

    @Transactional
    public GameInfoDto move(String from, String to) {
        ChessGame chessGame = chessGameRepository.findById(currentGameId)
                .orElseThrow(() -> new IllegalArgumentException("게임을 다시 시작해주세요."));

        List<Piece> pieces = pieceRepository.findAllByGameId(currentGameId);

        Board board = new Board(pieces);
        Position fromPosition = Position.of(from);
        Position toPosition = Position.of(to);

        board.move(fromPosition, toPosition);

        Piece fromPiece = pieces.stream()
                .filter(piece -> piece.matchPosition(fromPosition))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("이동하려는 말을 찾을 수 없습니다."));

        Piece toPiece = pieces.stream()
                .filter(piece -> piece.matchPosition(toPosition))
                .findAny()
                .orElse(null);

        fromPiece.updatePosition(toPosition);
        if (toPiece != null) {
            pieceRepository.delete(toPiece);
        }

        double scoreBlack = board.calculateScore(BLACK);
        double scoreWhite = board.calculateScore(WHITE);
        boolean isEnded = board.isEnded();

        chessGame.changeTurn(scoreWhite, scoreBlack, isEnded);

        List<Piece> changedPieces = pieceRepository.findAllByGameId(currentGameId);

        return new GameInfoDto(chessGame.getTurn(), chessGame.getScoreWhite(), chessGame.getScoreBlack(),
                chessGame.getGameStatus(), changedPieces);
    }

    public WinnerDto getWinner() {
        ChessGame chessGame = chessGameRepository.findById(currentGameId)
                .orElseThrow(() -> new IllegalArgumentException("게임을 다시 시작해주세요."));

        if (chessGame.matchGameStatus(BATTLE)) {
            throw new IllegalArgumentException("게임이 종료되지 않았습니다.");
        }

        return new WinnerDto(chessGame.getTurn().equals(BLACK) ? WHITE : BLACK);
    }
}
