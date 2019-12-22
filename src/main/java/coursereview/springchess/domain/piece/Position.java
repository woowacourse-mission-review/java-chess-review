package coursereview.springchess.domain.piece;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@ToString
public class Position {

    @Column(name = "rowPosition", nullable = false)
    private RowPosition row;

    @Column(name = "columnPosition", nullable = false)
    private ColumnPosition column;

    private Position() {
    }

    public Position(final RowPosition row, final ColumnPosition column) {
        this.row = row;
        this.column = column;
    }

    public RowPosition getRow() {
        return row;
    }

    public ColumnPosition getColumn() {
        return column;
    }
}
