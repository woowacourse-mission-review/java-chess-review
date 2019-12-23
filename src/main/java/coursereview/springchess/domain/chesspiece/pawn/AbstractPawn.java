package coursereview.springchess.domain.chesspiece.pawn;

import coursereview.springchess.domain.chesspiece.AbstractChessPiece;
import coursereview.springchess.domain.player.ChessGamePlayers;
import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractPawn extends AbstractChessPiece {

    private static final String SIGN = "P";

    @Override
    public ChessPositions findMovablePositions(final ChessPosition source, final ChessGamePlayers chessGamePlayers) {
        List<ChessPosition> positions = new ArrayList<>();

        Direction verticalDirection = getVerticalDirection();
        Optional<ChessPosition> nextPosition = source.moveAdjacentPositionBy(verticalDirection);
        nextPosition.ifPresent(position -> appendPosition(position, positions, chessGamePlayers));

        if (isPawnPosition(source)) {
            nextPosition.flatMap(position -> position.moveAdjacentPositionBy(verticalDirection))
                    .ifPresent(position -> appendPosition(position, positions, chessGamePlayers));
        }

        List<Direction> diagonalDirections = getDiagonalDirections();
        for (Direction diagonalDirection : diagonalDirections) {
            source.moveAdjacentPositionBy(diagonalDirection)
                    .ifPresent(position -> appendDiagonalPosition(position, positions, chessGamePlayers));
        }

        return new ChessPositions(positions);
    }

    private void appendPosition(final ChessPosition position, final List<ChessPosition> positions, final ChessGamePlayers chessGamePlayers) {
        if (isEmptyPosition(position, chessGamePlayers)) {
            positions.add(position);
        }
    }

    private void appendDiagonalPosition(final ChessPosition diagonalPosition, final List<ChessPosition> positions, final ChessGamePlayers chessGamePlayers) {
        if (isEnemyPositionAndIsNotAlliesPosition(diagonalPosition, chessGamePlayers)) {
            positions.add(diagonalPosition);
        }
    }

    private boolean isEnemyPositionAndIsNotAlliesPosition(final ChessPosition position, final ChessGamePlayers chessGamePlayers) {
        ChessPlayer currentPlayer = chessGamePlayers.getCurrentPlayer();
        ChessPlayer oppositePlayer = chessGamePlayers.getOppositePlayer();

        return currentPlayer.doesNotContain(position) && oppositePlayer.contains(position);
    }

    protected abstract Direction getVerticalDirection();

    protected abstract List<Direction> getDiagonalDirections();

    protected abstract boolean isPawnPosition(final ChessPosition chessPosition);

    @Override
    public boolean canMoveSeveralPositions() {
        return false;
    }

    @Override
    public String getSign() {
        return SIGN;
    }
}
