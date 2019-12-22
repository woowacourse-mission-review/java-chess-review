package coursereview.springchess.domain.piece;

public enum Type {

    PAWN("P"),
    KNIGHT("N"),
    BISHOP("B"),
    ROOK("R"),
    KING("K"),
    QUEEN("Q");

    private final String sign;

    Type(final String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
