package coursereview.springchess.service;

import coursereview.springchess.domain.ChessGame;
import coursereview.springchess.domain.player.BlackPlayer;
import coursereview.springchess.domain.player.WhitePlayer;
import coursereview.springchess.domain.position.MovablePositions;
import coursereview.springchess.dto.ChessGameResponse;
import coursereview.springchess.dto.ChessMovablePositionsResponse;
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
}
