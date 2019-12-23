package coursereview.springchess.domain.chesspiece.pawn;

import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.Direction;

import java.util.Arrays;
import java.util.List;

public class WhitePawn extends AbstractPawn {

    @Override
    protected Direction getVerticalDirection() {
        return Direction.N;
    }

    @Override
    protected List<Direction> getDiagonalDirections() {
        return Arrays.asList(Direction.NW, Direction.NE);
    }

    @Override
    protected boolean isPawnPosition(final ChessPosition chessPosition) {
        return chessPosition.isInitialWhitePawnPosition();
    }
}
