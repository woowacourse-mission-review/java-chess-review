package coursereview.springchess.domain.piece;

import java.util.Arrays;

public enum ColumnPosition {

    A("a"),
    B("b"),
    C("c"),
    D("d"),
    E("e"),
    F("f"),
    G("g"),
    H("h");

    public static final String COLUMN_BOUND_EXCEPTION_MESSAGE = "더 이상 이동할 수 없습니다.";
    public static final String NOT_FOUND_COLUMN_EXCEPTION_MESSAGE = "해당 Column 을 찾을 수 없습니다.";

    private final String column;

    ColumnPosition(final String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }

    public static ColumnPosition of(String column) {
        return Arrays.stream(ColumnPosition.values())
                .filter(columnPosition -> columnPosition.column.equals(column))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_COLUMN_EXCEPTION_MESSAGE));
    }

    private static int calculateAscii(String column) {
        return column.charAt(0);
    }

    public boolean hasNext(final int columnShiftUnit) {
        int addedColumn = calculateAscii(column) + columnShiftUnit;
        return (addedColumn >= calculateAscii(A.column)) && (addedColumn <= calculateAscii(H.column));
    }

    public ColumnPosition next(final int columnShiftUnit) {
        return Arrays.stream(ColumnPosition.values())
                .filter(rowPosition -> calculateAscii(rowPosition.column) == calculateAscii(this.column) + columnShiftUnit)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(COLUMN_BOUND_EXCEPTION_MESSAGE));
    }
}
