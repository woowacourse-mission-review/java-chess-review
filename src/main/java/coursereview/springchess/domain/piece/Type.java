package coursereview.springchess.domain.piece;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.MAX_VALUE;

public enum Type {

    PAWN("P", null),
    KNIGHT("N", determineVectors(Direction.valueOfKnight(), 1)),
    BISHOP("B", determineVectors(Direction.valueOfDiagonal(), MAX_VALUE)),
    ROOK("R", determineVectors(Direction.valueOfOrthogonal(), MAX_VALUE)),
    KING("K", determineVectors(getAllDirections(), 1)),
    QUEEN("Q", determineVectors(getAllDirections(), MAX_VALUE));

    private final String sign;
    private final List<Vector> vectors;

    Type(final String sign, final List<Vector> vectors) {
        this.sign = sign;
        this.vectors = vectors;
    }

    private static List<Vector> determineVectors(List<Direction> directions, int distance) {
        return directions.stream()
                .map(direction -> new Vector(direction, distance))
                .collect(Collectors.toList());
    }

    private static List<Direction> getAllDirections() {
        return Stream.of(Direction.valueOfOrthogonal(), Direction.valueOfDiagonal())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public List<Vector> getVectors() {
        return vectors;
    }

    public String getSign() {
        return sign;
    }
}
