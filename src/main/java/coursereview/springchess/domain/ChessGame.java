package coursereview.springchess.domain;

import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.MovablePositions;

public class ChessGame {

    private final ChessPlayer whitePlayer;
    private final ChessPlayer blackPlayer;
    private boolean isWhiteTurn;

    public ChessGame(final ChessPlayer whitePlayer, final ChessPlayer blackPlayer, final boolean isWhiteTurn) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.isWhiteTurn = isWhiteTurn;
    }

    private ChessPlayer findCurrentTurnPlayer() {
        return isWhiteTurn ? whitePlayer : blackPlayer;
    }

    private ChessPlayer findOppositeTurnPlayer() {
        return isWhiteTurn ? blackPlayer : whitePlayer;
    }

    public MovablePositions findMovablePositions() {
        MovablePositions whiteMovablePositions = whitePlayer.findMovablePositions(blackPlayer);
        MovablePositions blackMovablePositions = blackPlayer.findMovablePositions(whitePlayer);

        return whiteMovablePositions.addAll(blackMovablePositions);
    }

    public ChessPlayer getWhitePlayer() {
        return whitePlayer;
    }

    public ChessPlayer getBlackPlayer() {
        return blackPlayer;
    }

    public boolean isWhiteTurn() {
        return isWhiteTurn;
    }
}
