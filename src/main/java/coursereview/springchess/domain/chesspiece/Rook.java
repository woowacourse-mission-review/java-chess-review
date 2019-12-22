package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.exception.ChessPositionNotFoundException;
import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.Direction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Rook implements ChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.N, Direction.E, Direction.S, Direction.W);
    private static final String SIGN = "R";

    @Override
    public ChessPositions findMovablePositions(final ChessPosition source, final ChessPlayer currentPlayer, final ChessPlayer oppositePlayer) {
        ChessPositions chessPositions = new ChessPositions(new ArrayList<>());
        DIRECTIONS.forEach(direction -> {
            List<ChessPosition> positions = findMovablePositionsByDirection(source, direction, currentPlayer, oppositePlayer);
            chessPositions.addAll(positions);
        });
        return chessPositions;
    }

    private List<ChessPosition> findMovablePositionsByDirection(ChessPosition source, final Direction direction
            , final ChessPlayer currentPlayer, final ChessPlayer oppositePlayer) {
        List<ChessPosition> positions = new ArrayList<>();
        try {
            ChessPosition nextPosition = source.moveAdjacentPositionBy(direction);
            while (canMoveSeveralPositions() && currentPlayer.doesNotContain(nextPosition) && oppositePlayer.doesNotContain(nextPosition)) {
                positions.add(nextPosition);
                nextPosition = nextPosition.moveAdjacentPositionBy(direction);
            }

            if (oppositePlayer.contains(nextPosition)) {
                positions.add(nextPosition);
            }

            return positions;
        } catch (ChessPositionNotFoundException e) {
            return positions;
        }
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
