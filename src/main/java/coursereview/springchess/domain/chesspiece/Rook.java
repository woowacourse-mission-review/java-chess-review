package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.player.ChessGamePlayers;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook extends AbstractChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.N, Direction.E, Direction.S, Direction.W);
    private static final String SIGN = "R";

    @Override
    public ChessPositions findMovablePositions(final ChessPosition source, ChessGamePlayers chessGamePlayers) {
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
