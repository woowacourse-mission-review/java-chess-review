package coursereview.springchess.domain.piece;

import org.junit.jupiter.api.Test;

import static coursereview.springchess.domain.piece.ColumnPosition.A;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ColumnPositionTest {

    @Test
    void name() {
        assertEquals(ColumnPosition.of("a"), A);
    }
}