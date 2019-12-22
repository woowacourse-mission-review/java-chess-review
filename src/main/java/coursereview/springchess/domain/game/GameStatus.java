package coursereview.springchess.domain.game;

public enum GameStatus {

    BATTLE("battle"),
    END("end");

    private final String sign;

    GameStatus(final String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
