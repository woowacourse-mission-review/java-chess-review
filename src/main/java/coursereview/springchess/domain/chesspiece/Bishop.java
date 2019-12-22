package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bishop extends AbstractChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.NE, Direction.SE, Direction.SW, Direction.NW);
    private static final String SIGN = "B";

    @Override
    public ChessPositions findMovablePositions(final ChessPosition source, final ChessPlayer currentPlayer, final ChessPlayer oppositePlayer) {
        ChessPositions chessPositions = new ChessPositions(new ArrayList<>());
        DIRECTIONS.forEach(direction -> {
            List<ChessPosition> positions = super.findMovablePositionsByDirection(source, direction, currentPlayer, oppositePlayer);
            chessPositions.addAll(positions);
        });
        return chessPositions;
    }

    @Override
    public boolean canMoveSeveralPositions() {
        return true;
    }

    @Override
    public String getSign() {
        return SIGN;
    }
}
