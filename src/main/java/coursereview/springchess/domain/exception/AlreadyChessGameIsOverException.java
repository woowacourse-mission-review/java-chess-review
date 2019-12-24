package coursereview.springchess.domain.exception;

public class AlreadyChessGameIsOverException extends IllegalArgumentException {

    public static final String ALREADY_CHESS_GAME_IS_OVER_MESSAGE = "게임이 이미 끝났습니다.";

    public AlreadyChessGameIsOverException() {
        super(ALREADY_CHESS_GAME_IS_OVER_MESSAGE);
    }
}
