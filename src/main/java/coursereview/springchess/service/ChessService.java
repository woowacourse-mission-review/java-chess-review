package coursereview.springchess.service;

import coursereview.springchess.domain.ChessGame;
import coursereview.springchess.domain.player.BlackPlayer;
import coursereview.springchess.domain.player.WhitePlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.MovablePositions;
import coursereview.springchess.dto.ChessGameResponse;
import coursereview.springchess.dto.ChessMovablePositionsResponse;
import coursereview.springchess.dto.ChessMovementRequest;
import org.springframework.stereotype.Service;

@Service
public class ChessService {

    private ChessGame chessGame = generateInitialBoard();

    public ChessGameResponse initBoard() {
        this.chessGame = generateInitialBoard();
        return ChessAssembler.toGameResponse(chessGame);
    }

    private ChessGame generateInitialBoard() {
        return new ChessGame(new WhitePlayer(), new BlackPlayer(), true);
    }

    public ChessMovablePositionsResponse findMovablePositions() {
        MovablePositions movablePositions = chessGame.findMovablePositions();
        return ChessAssembler.toMovablePositionResponse(movablePositions);
    }

    public ChessGameResponse move(final ChessMovementRequest chessMovementRequest) {
        ChessPosition source = ChessPosition.find(chessMovementRequest.getFrom());
        ChessPosition target = ChessPosition.find(chessMovementRequest.getTo());

        chessGame.move(source, target);
        return ChessAssembler.toGameResponse(chessGame);
    }
}
