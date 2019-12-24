package coursereview.springchess.domain.player;

public class ChessGamePlayers {

    private final ChessPlayer currentPlayer;
    private final ChessPlayer oppositePlayer;

    public ChessGamePlayers(final ChessPlayer currentPlayer, final ChessPlayer oppositePlayer) {
        this.currentPlayer = currentPlayer;
        this.oppositePlayer = oppositePlayer;
    }

    public ChessPlayer getCurrentPlayer() {
        return currentPlayer;
    }

    public ChessPlayer getOppositePlayer() {
        return oppositePlayer;
    }
}
