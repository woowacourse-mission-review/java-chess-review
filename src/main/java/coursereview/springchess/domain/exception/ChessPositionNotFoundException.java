package coursereview.springchess.domain.exception;

public class ChessPositionNotFoundException extends IllegalArgumentException {

    public static final String CHESS_POSITION_NOT_FOUND_MESSAGE = "올바른 위치가 아닙니다.";

    public ChessPositionNotFoundException() {
        super(CHESS_POSITION_NOT_FOUND_MESSAGE);
    }
}
