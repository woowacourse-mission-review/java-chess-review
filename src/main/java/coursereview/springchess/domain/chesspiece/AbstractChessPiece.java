package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.exception.ChessPositionNotFoundException;
import coursereview.springchess.domain.player.ChessGamePlayers;
import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.Direction;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractChessPiece implements ChessPiece {

    @Override
    public ChessPositions findMovablePositions(final ChessPosition source, final ChessGamePlayers chessGamePlayers) {
        ChessPositions chessPositions = new ChessPositions(new ArrayList<>());
        getDirections().forEach(direction -> {
            List<ChessPosition> positions = findMovablePositionsByDirection(source, direction, chessGamePlayers);
            chessPositions.addAll(positions);
        });
        return chessPositions;
    }

    protected List<ChessPosition> findMovablePositionsByDirection(final ChessPosition source, final Direction direction
            , final ChessGamePlayers chessGamePlayers) {
        List<ChessPosition> positions = new ArrayList<>();

        try {
            ChessPosition nextPosition = source.moveAdjacentPositionBy(direction);
            boolean isPositionMovable = isEmptyPosition(nextPosition, chessGamePlayers);
            while (isPositionMovable) {
                positions.add(nextPosition);
                nextPosition = nextPosition.moveAdjacentPositionBy(direction);
                isPositionMovable = canMoveSeveralPositions() && isEmptyPosition(nextPosition, chessGamePlayers);
            }

            ChessPlayer oppositePlayer = chessGamePlayers.getOppositePlayer();
            if (oppositePlayer.contains(nextPosition)) {
                positions.add(nextPosition);
            }

            return positions;
        } catch (ChessPositionNotFoundException e) {
            return positions;
        }
    }

    protected boolean isEmptyPosition(final ChessPosition position, final ChessGamePlayers chessGamePlayers) {
        ChessPlayer currentPlayer = chessGamePlayers.getCurrentPlayer();
        ChessPlayer oppositePlayer = chessGamePlayers.getOppositePlayer();

        return currentPlayer.doesNotContain(position) && oppositePlayer.doesNotContain(position);
    }

    protected abstract List<Direction> getDirections();
}
