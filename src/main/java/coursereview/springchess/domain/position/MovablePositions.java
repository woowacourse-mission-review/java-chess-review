package coursereview.springchess.domain.position;

import java.util.Map;

public class MovablePositions {

    private final Map<ChessPosition, ChessPositions> positions;

    public MovablePositions(final Map<ChessPosition, ChessPositions> positions) {
        this.positions = positions;
    }

    public MovablePositions addAll(final MovablePositions movablePositions) {
        for (Map.Entry<ChessPosition, ChessPositions> entry : movablePositions.positions.entrySet()) {
            this.positions.put(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public Map<ChessPosition, ChessPositions> getPositions() {
        return positions;
    }
}
