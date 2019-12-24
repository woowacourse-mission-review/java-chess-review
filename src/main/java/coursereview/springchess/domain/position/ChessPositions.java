package coursereview.springchess.domain.position;

import java.util.List;

public class ChessPositions {

    private final List<ChessPosition> positions;

    public ChessPositions(final List<ChessPosition> positions) {
        this.positions = positions;
    }

    public void addAll(final List<ChessPosition> positions) {
        this.positions.addAll(positions);
    }

    public boolean contains(final ChessPosition chessPosition) {
        return positions.contains(chessPosition);
    }

    public int size() {
        return positions.size();
    }

    public List<ChessPosition> getPositions() {
        return positions;
    }
}
