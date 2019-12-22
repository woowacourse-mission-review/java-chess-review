package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.exception.ChessPositionNotFoundException;
import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.Direction;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractChessPiece implements ChessPiece {

    protected List<ChessPosition> findMovablePositionsByDirection(ChessPosition source, final Direction direction
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
}
