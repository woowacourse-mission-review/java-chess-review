package coursereview.springchess.domain.piece;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
@AllArgsConstructor
@Embeddable
@Getter
@EqualsAndHashCode
@ToString
public class Position {

    @Column(name = "rowPosition", nullable = false)
    private RowPosition row;

    @Column(name = "columnPosition", nullable = false)
    private ColumnPosition column;

    public boolean matchRow(final RowPosition rowPosition) {
        return row.equals(rowPosition);
    }

    public Position next(final Direction direction) {
        return new Position(row.next(direction.getRowShiftUnit()), column.next(direction.getColumnShiftUnit()));
    }

    public boolean hasNext(Direction direction) {
        return row.hasNext(direction.getRowShiftUnit()) && column.hasNext(direction.getColumnShiftUnit());
    }

    public boolean matchColumn(final Position candidate) {
        return column.equals(candidate.column);
    }
}
