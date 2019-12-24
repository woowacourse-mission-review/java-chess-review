package coursereview.springchess.domain;

import coursereview.springchess.domain.exception.AlreadyChessGameIsOverException;
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
        if (isGameOver()) {
            throw new AlreadyChessGameIsOverException();
        }

        ChessPlayer currentPlayer = findCurrentTurnPlayer();
        ChessPlayer oppositePlayer = findOppositeTurnPlayer();
        currentPlayer.move(source, target, oppositePlayer);

        toggleTurn();
    }

    public boolean isGameOver() {
        return !isGameGoingOn();
    }

    public boolean isGameGoingOn() {
        return whitePlayer.isKingAlive() && blackPlayer.isKingAlive();
    }

    public boolean isWhitePlayerWinner() {
        return (isGameOver() && whitePlayer.isKingAlive())
                || (isGameGoingOn() && whitePlayer.calculateScore() > blackPlayer.calculateScore());
    }

    public boolean isBlackPlayerWinner() {
        return (isGameOver() && blackPlayer.isKingAlive())
                || (isGameGoingOn() && blackPlayer.calculateScore() > whitePlayer.calculateScore());
    }

    public boolean isGameDraw() {
        return isGameGoingOn() && whitePlayer.calculateScore() == blackPlayer.calculateScore();
    }

    public double getScoreOfWhitePlayer() {
        return whitePlayer.calculateScore();
    }

    public double getScoreOfBlackPlayer() {
        return blackPlayer.calculateScore();
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
