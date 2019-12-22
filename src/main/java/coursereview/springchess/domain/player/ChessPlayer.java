package coursereview.springchess.domain.player;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.position.ChessPosition;

import java.util.EnumMap;
import java.util.Map;

public class ChessPlayer {

    protected Map<ChessPosition, ChessPiece> pieces;

    public ChessPlayer() {
        this.pieces = new EnumMap<>(ChessPosition.class);
    }

    public ChessPlayer(final Map<ChessPosition, ChessPiece> pieces) {
        this.pieces = pieces;
    }

    public boolean contains(final ChessPosition chessPosition) {
        return pieces.containsKey(chessPosition);
    }

    public boolean doesNotContain(final ChessPosition chessPosition) {
        return !contains(chessPosition);
    }

    public Map<ChessPosition, ChessPiece> getPieces() {
        return pieces;
    }
}
