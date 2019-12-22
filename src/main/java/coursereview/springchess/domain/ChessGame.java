package coursereview.springchess.domain;

import coursereview.springchess.domain.player.ChessPlayer;

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
