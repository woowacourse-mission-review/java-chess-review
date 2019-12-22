package coursereview.springchess.domain.exception;

public class ChessPieceNotFoundOnSourceException extends IllegalArgumentException {

    public static final String CHESS_PIECE_NOT_FOUND_ON_SOURCE_MESSAGE = "움직일 수 있는 말이 아닙니다.";

    public ChessPieceNotFoundOnSourceException() {
        super(CHESS_PIECE_NOT_FOUND_ON_SOURCE_MESSAGE);
    }
}
