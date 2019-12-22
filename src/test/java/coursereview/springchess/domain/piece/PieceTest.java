package coursereview.springchess.domain.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coursereview.springchess.domain.common.Color.WHITE;
import static coursereview.springchess.domain.piece.ColumnPosition.A;
import static coursereview.springchess.domain.piece.ColumnPosition.B;
import static coursereview.springchess.domain.piece.RowPosition.ONE;
import static coursereview.springchess.domain.piece.RowPosition.TWO;
import static coursereview.springchess.domain.piece.Type.PAWN;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PieceTest {

    private final long gameId = 1L;
    private final PieceInfo pieceInfo = new PieceInfo(PAWN, WHITE);

    @DisplayName("Position 이 같을 경우 true 를 리턴하는지")
    @Test
    void match_position() {
        Position position = new Position(ONE, A);
        Piece piece = new Piece(gameId , pieceInfo, position);
        assertTrue(piece.matchPosition(position));
    }

    @DisplayName("Position 이 다를 경우 false 를 리턴하는지")
    @Test
    void not_match_position() {
        Piece piece = new Piece(gameId, pieceInfo, new Position(TWO, B));
        assertFalse(piece.matchPosition(new Position(ONE, A)));
    }
}