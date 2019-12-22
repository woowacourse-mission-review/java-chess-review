package coursereview.springchess.domain.piece;

public enum RowPosition {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    private final int row;

    RowPosition(final int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }
}
