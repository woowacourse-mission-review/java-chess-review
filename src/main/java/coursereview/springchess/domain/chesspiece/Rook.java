package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.Direction;

import java.util.Arrays;
import java.util.List;

public class Rook implements ChessPiece {

    private static final List<Direction> DIRECTIONS = Arrays.asList(Direction.N, Direction.E, Direction.S, Direction.W);
    private static final String SIGN = "R";

    @Override
    public ChessPositions findMovablePositions(final ChessPosition source, final ChessPlayer currentPlayer, final ChessPlayer oppositePlayer) {
        for (Direction direction : DIRECTIONS) {
            ChessPosition nextPosition = source.moveAdjacentPositionBy(direction);
        }
        return null;
    }

    @Override
    public String getSign() {
        return SIGN;
    }
}
