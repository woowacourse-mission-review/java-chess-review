package coursereview.springchess.domain.piece;

public enum ColumnPosition {

    A("a"),
    B("b"),
    C("c"),
    D("d"),
    E("e"),
    F("f"),
    G("g"),
    H("h");

    private final String column;

    ColumnPosition(final String column) {
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
