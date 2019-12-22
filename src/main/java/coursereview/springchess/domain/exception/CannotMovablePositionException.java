package coursereview.springchess.domain.exception;

public class CannotMovablePositionException extends IllegalArgumentException {

    public static final String CANNOT_MOVABLE_POSITION_MESSAGE = "해당 위치로는 말을 움직일 수 없습니다.";

    public CannotMovablePositionException() {
        super(CANNOT_MOVABLE_POSITION_MESSAGE);
    }
}
