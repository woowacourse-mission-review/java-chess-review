package coursereview.springchess.domain;

import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
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

    public MovablePositions findMovablePositions() {
        MovablePositions whiteMovablePositions = whitePlayer.findMovablePositions(blackPlayer);
        MovablePositions blackMovablePositions = blackPlayer.findMovablePositions(whitePlayer);

        return whiteMovablePositions.addAll(blackMovablePositions);
    }

    public void move(final ChessPosition source, final ChessPosition target) {
        ChessPlayer currentPlayer = findCurrentTurnPlayer();
        ChessPlayer oppositePlayer = findOppositeTurnPlayer();
        currentPlayer.move(source, target, oppositePlayer);

        toggleTurn();
    }

    private ChessPlayer findCurrentTurnPlayer() {
        return isWhiteTurn ? whitePlayer : blackPlayer;
    }

    private ChessPlayer findOppositeTurnPlayer() {
        return isWhiteTurn ? blackPlayer : whitePlayer;
    }

    private void toggleTurn() {
        this.isWhiteTurn = !isWhiteTurn;
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
