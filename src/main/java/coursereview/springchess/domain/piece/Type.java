package coursereview.springchess.domain.piece;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.MAX_VALUE;

public enum Type {

    PAWN("P", null, 1.0),
    KNIGHT("N", determineVectors(Direction.valueOfKnight(), 1), 2.5),
    BISHOP("B", determineVectors(Direction.valueOfDiagonal(), MAX_VALUE), 3.0),
    ROOK("R", determineVectors(Direction.valueOfOrthogonal(), MAX_VALUE), 5.0),
    KING("K", determineVectors(getAllDirections(), 1), 9.0),
    QUEEN("Q", determineVectors(getAllDirections(), MAX_VALUE), 0.0);

    private final String sign;
    private final List<Vector> vectors;
    private final double score;

    Type(final String sign, final List<Vector> vectors, final double score) {
        this.sign = sign;
        this.vectors = vectors;
        this.score = score;
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

    public double getScore() {
        return score;
    }
}
