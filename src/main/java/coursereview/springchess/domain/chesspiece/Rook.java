package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.position.Direction;

import java.util.Arrays;
import java.util.List;

public class Rook extends AbstractChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.N, Direction.E, Direction.S, Direction.W);
    private static final String SIGN = "R";
    private static final double SCORE = 5;

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
