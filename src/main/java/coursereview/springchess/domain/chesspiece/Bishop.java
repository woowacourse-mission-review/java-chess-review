package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.position.Direction;

import java.util.Arrays;
import java.util.List;

public class Bishop extends AbstractChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.NE, Direction.SE, Direction.SW, Direction.NW);
    private static final String SIGN = "B";

    @Override
    public boolean canMoveSeveralPositions() {
        return true;
    }

    @Override
    public String getSign() {
        return SIGN;
    }

    @Override
    protected List<Direction> getDirections() {
        return DIRECTIONS;
    }
}
