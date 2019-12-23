package coursereview.springchess.domain.chesspiece.pawn;

import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.Direction;

import java.util.Arrays;
import java.util.List;

public class BlackPawn extends AbstractPawn {

    @Override
    protected Direction getVerticalDirection() {
        return Direction.S;
    }

    @Override
    protected List<Direction> getDiagonalDirections() {
        return Arrays.asList(Direction.SW, Direction.SE);
    }

    @Override
    protected boolean isPawnPosition(final ChessPosition chessPosition) {
        return chessPosition.isInitialBlackPawnPosition();
    }
}
