package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.player.ChessGamePlayers;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knight extends AbstractChessPiece {

    private static final List<Direction> DIRECTIONS
            = Arrays.asList(Direction.NNE, Direction.EEN, Direction.EES, Direction.SSE
            , Direction.SSW, Direction.WWS, Direction.WWN, Direction.NNW);
    private static final String SIGN = "N";

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
        return false;
    }

    @Override
    public String getSign() {
        return SIGN;
    }
}
