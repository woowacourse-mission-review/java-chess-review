package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.position.Direction;

import java.util.Arrays;
import java.util.List;

public class Knight extends AbstractChessPiece {

    private static final List<Direction> DIRECTIONS
            = Arrays.asList(Direction.NNE, Direction.EEN, Direction.EES, Direction.SSE
            , Direction.SSW, Direction.WWS, Direction.WWN, Direction.NNW);
    private static final String SIGN = "N";
    private static final double SCORE = 2.5;

    @Override
    public boolean canMoveSeveralPositions() {
        return false;
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
