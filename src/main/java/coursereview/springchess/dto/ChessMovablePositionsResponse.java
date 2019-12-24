package coursereview.springchess.dto;

import java.util.List;
import java.util.Map;

public class ChessMovablePositionsResponse {

    private Map<String, List<String>> movablePositions;

    public ChessMovablePositionsResponse(final Map<String, List<String>> movablePositions) {
        this.movablePositions = movablePositions;
    }

    public Map<String, List<String>> getMovablePositions() {
        return movablePositions;
    }
}
