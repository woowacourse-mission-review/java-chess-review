package coursereview.springchess.domain.common;

public enum Color {

    BLACK("b"),
    WHITE("w");

    private final String sign;

    Color(final String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
