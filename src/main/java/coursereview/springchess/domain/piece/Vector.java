package coursereview.springchess.domain.piece;

import java.util.ArrayList;
import java.util.List;

public class Vector {

    private final Direction direction;
    private final int distance;

    public Vector(final Direction direction, final int distance) {
        this.direction = direction;
        this.distance = distance;
    }

    public List<Position> getMovablePositions(final Position position) {
        List<Position> positions = new ArrayList<>();
        Position current = position;
        int count = 0;
        while(current.hasNext(direction) && ++count <= distance) {
            current = current.next(direction);
            positions.add(current);
        }
        return positions;
    }
}
