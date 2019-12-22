package coursereview.springchess.service;

import coursereview.springchess.controller.dto.GameInfoDto;
import coursereview.springchess.domain.ChessGameRepository;
import coursereview.springchess.domain.PieceRepository;
import coursereview.springchess.domain.board.Board;
import coursereview.springchess.domain.board.BoardManager;
import coursereview.springchess.domain.board.DefaultBoardInitializer;
import coursereview.springchess.domain.game.ChessGame;
import coursereview.springchess.domain.piece.Piece;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static coursereview.springchess.domain.common.Color.WHITE;

@Service
public class ChessGameService {

    private static final Logger log = LoggerFactory.getLogger(ChessGameService.class);

    private final ChessGameRepository chessGameRepository;
    private final PieceRepository pieceRepository;

    private final BoardManager boardManager = new BoardManager(new DefaultBoardInitializer());

    @Autowired
    public ChessGameService(final ChessGameRepository chessGameRepository, final PieceRepository pieceRepository) {
        this.chessGameRepository = chessGameRepository;
        this.pieceRepository = pieceRepository;
    }

    public GameInfoDto initialize() {
        ChessGame chessGame = new ChessGame();
        ChessGame savedChessGame = chessGameRepository.save(chessGame);
        Board board = boardManager.initializeBoard(savedChessGame.getId());
        List<Piece> pieces = board.getPieces();
        List<Piece> savedPieces = pieceRepository.saveAll(pieces);
        return new GameInfoDto(chessGame.getTurn(), chessGame.getScoreWhite(), chessGame.getScoreBlack(),
                chessGame.getGameStatus(), savedPieces);
    }
}
