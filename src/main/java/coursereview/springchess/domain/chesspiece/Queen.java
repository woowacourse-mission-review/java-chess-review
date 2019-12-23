package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.player.ChessGamePlayers;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queen extends AbstractChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.N, Direction.NE, Direction.E, Direction.SE
            , Direction.S, Direction.SW, Direction.W, Direction.NW);
    private static final String SIGN = "Q";

    @Override
    public ChessPositions findMovablePositions(final ChessPosition source, final ChessGamePlayers chessGamePlayers) {
        ChessPositions chessPositions = new ChessPositions(new ArrayList<>());
        DIRECTIONS.forEach(direction -> {
            List<ChessPosition> positions = super.findMovablePositionsByDirection(source, direction, chessGamePlayers);
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
