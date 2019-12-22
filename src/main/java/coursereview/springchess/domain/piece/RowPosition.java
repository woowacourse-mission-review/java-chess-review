package coursereview.springchess.domain.piece;

import java.util.Arrays;

public enum RowPosition {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    public static final String ROW_BOUND_EXCEPTION = "더 이상 이동할 수 없습니다.";

    private final int row;

    RowPosition(final int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public RowPosition next(final int rowShiftUnit) {
        return Arrays.stream(RowPosition.values())
                .filter(rowPosition -> rowPosition.row == this.row + rowShiftUnit)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ROW_BOUND_EXCEPTION));
    }

    public boolean hasNext(final int rowShiftUnit) {
        int addedRow = row + rowShiftUnit;
        return (addedRow >= ONE.row) && (addedRow <= EIGHT.row);
    }
}
