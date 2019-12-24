package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.position.Direction;

import java.util.Arrays;
import java.util.List;

public class Queen extends AbstractChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.N, Direction.NE, Direction.E, Direction.SE
            , Direction.S, Direction.SW, Direction.W, Direction.NW);
    private static final String SIGN = "Q";
    private static final double SCORE = 9;

    @Override
    public boolean canMoveSeveralPositions() {
        return true;
    }

    @Override
    public String getSign() {
        return SIGN;
    }

    @Override
    public double getScore() {
        return SCORE;
    }

    @Override
    protected List<Direction> getDirections() {
        return DIRECTIONS;
    }
}
