package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.player.ChessGamePlayers;
import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.Direction;

import java.util.ArrayList;
import java.util.List;

public class WhitePawn extends AbstractChessPiece {

    private static final String SIGN = "P";

    @Override
    public ChessPositions findMovablePositions(final ChessPosition source, final ChessGamePlayers chessGamePlayers) {
        List<ChessPosition> positions = new ArrayList<>();

        ChessPosition nextPosition = source.moveAdjacentPositionBy(Direction.N);
        appendPosition(nextPosition, positions, chessGamePlayers);

        if (source.isInitialWhitePawnPosition()) {
            nextPosition = nextPosition.moveAdjacentPositionBy(Direction.N);
            appendPosition(nextPosition, positions, chessGamePlayers);
        }

        ChessPosition diagonalNextPosition = source.moveAdjacentPositionBy(Direction.NW);
        appendDiagonalPosition(diagonalNextPosition, positions, chessGamePlayers);
        ChessPosition diagonalNextPosition2 = source.moveAdjacentPositionBy(Direction.NE);
        appendDiagonalPosition(diagonalNextPosition2, positions, chessGamePlayers);

        return new ChessPositions(positions);
    }

    private void appendPosition(final ChessPosition position, final List<ChessPosition> positions, final ChessGamePlayers chessGamePlayers) {
        if (isEmptyPosition(position, chessGamePlayers)) {
            positions.add(position);
        }
    }

    private void appendDiagonalPosition(final ChessPosition diagonalPosition, final List<ChessPosition> positions, final ChessGamePlayers chessGamePlayers) {
        if (isEnemyPositionAndIsNotAlliesPosition(diagonalPosition, chessGamePlayers)) {
            positions.add(diagonalPosition);
        }
    }

    private boolean isEnemyPositionAndIsNotAlliesPosition(final ChessPosition position, final ChessGamePlayers chessGamePlayers) {
        ChessPlayer currentPlayer = chessGamePlayers.getCurrentPlayer();
        ChessPlayer oppositePlayer = chessGamePlayers.getOppositePlayer();

        return currentPlayer.doesNotContain(position) && oppositePlayer.contains(position);
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
