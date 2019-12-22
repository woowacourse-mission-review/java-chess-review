package coursereview.springchess.domain.piece;

import coursereview.springchess.domain.common.Color;
import coursereview.springchess.domain.common.ColorToBooleanConverter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import java.util.List;
import java.util.stream.Collectors;

import static coursereview.springchess.domain.common.Color.WHITE;
import static coursereview.springchess.domain.piece.RowPosition.SEVEN;
import static coursereview.springchess.domain.piece.RowPosition.TWO;
import static coursereview.springchess.domain.piece.Type.PAWN;

@Embeddable
@ToString
public class PieceInfo {

    private static final int PAWN_INITIAL_MOVE_DISTANCE = 2;
    private static final int PAWN_DEFAULT_MOVE_DISTANCE = 1;

    @Column(name = "type", nullable = false)
    private Type type;

    @Column(name = "color", nullable = false)
    @Convert(converter = ColorToBooleanConverter.class)
    private Color color;

    private PieceInfo() {
    }

    public PieceInfo(final Type type, final Color color) {
        this.type = type;
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }

    public boolean matchColor(final Color color) {
        return this.color.equals(color);
    }

    public List<List<Position>> getMovableCandidatesFor(final Position position) {
        List<Vector> vectors = type.equals(PAWN) ? getMovableVectorsOfPawn(position) : type.getVectors();
        return vectors.stream()
                .map(vector -> vector.getMovablePositions(position))
                .collect(Collectors.toList());
    }

    private List<Vector> getMovableVectorsOfPawn(final Position position) {
        List<Vector> vectors = Direction.valueOfPawnAttack(color).stream()
                .map(direction -> new Vector(direction, PAWN_DEFAULT_MOVE_DISTANCE))
                .collect(Collectors.toList());

        int distance = position.matchRow(color.equals(WHITE) ? TWO : SEVEN) ? PAWN_INITIAL_MOVE_DISTANCE : PAWN_DEFAULT_MOVE_DISTANCE;
        vectors.add(new Vector(Direction.valueOfPawnMove(color), distance));

        return vectors;
    }

    public boolean matchColor(final PieceInfo pieceInfo) {
        return this.color.equals(pieceInfo.color);
    }

    public boolean matchType(final Type type) {
        return this.type.equals(type);
    }

    public double getScore() {
        return type.getScore();
    }
}
