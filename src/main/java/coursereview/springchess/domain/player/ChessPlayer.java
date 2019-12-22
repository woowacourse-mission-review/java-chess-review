package coursereview.springchess.domain.player;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.MovablePositions;

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

    public MovablePositions findMovablePositions(final ChessPlayer oppositePlayer) {
        Map<ChessPosition, ChessPositions> positions = new EnumMap<>(ChessPosition.class);
        pieces.forEach((key, value) -> {
            ChessPositions movablePositions = value.findMovablePositions(key, this, oppositePlayer);
            positions.put(key, movablePositions);
        });
        return new MovablePositions(positions);
    }

    public Map<ChessPosition, ChessPiece> getPieces() {
        return pieces;
    }
}
