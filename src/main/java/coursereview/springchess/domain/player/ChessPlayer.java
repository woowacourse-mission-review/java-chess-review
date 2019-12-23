package coursereview.springchess.domain.player;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.exception.CannotMovablePositionException;
import coursereview.springchess.domain.exception.ChessPieceNotFoundOnSourceException;
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
        ChessGamePlayers chessGamePlayers = new ChessGamePlayers(this, oppositePlayer);

        pieces.forEach((key, value) -> {
            ChessPositions movablePositions = value.findMovablePositions(key, chessGamePlayers);
            positions.put(key, movablePositions);
        });
        return new MovablePositions(positions);
    }

    public void move(final ChessPosition source, final ChessPosition target, final ChessPlayer oppositePlayer) {
        if (doesNotContain(source)) {
            throw new ChessPieceNotFoundOnSourceException();
        }

        MovablePositions movablePositions = findMovablePositions(oppositePlayer);
        if (movablePositions.doesNotHaveMovementAbout(source, target)) {
            throw new CannotMovablePositionException();
        }

        moveChessPiece(source, target);
        removeEnemy(target, oppositePlayer);
    }

    private void moveChessPiece(final ChessPosition source, final ChessPosition target) {
        ChessPiece chessPiece = pieces.remove(source);
        pieces.put(target, chessPiece);
    }

    private void removeEnemy(final ChessPosition target, final ChessPlayer oppositePlayer) {
        if (oppositePlayer.contains(target)) {
            oppositePlayer.pieces.remove(target);
        }
    }

    public Map<ChessPosition, ChessPiece> getPieces() {
        return pieces;
    }
}
