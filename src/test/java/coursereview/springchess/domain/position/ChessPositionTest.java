package coursereview.springchess.domain.position;

import coursereview.springchess.domain.exception.ChessPositionNotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChessPositionTest {

    @Test
    void moveAdjacentPositionBy() {
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.N)).hasValue(ChessPosition.D5);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.E)).hasValue(ChessPosition.E4);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.S)).hasValue(ChessPosition.D3);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.W)).hasValue(ChessPosition.C4);

        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.NE)).hasValue(ChessPosition.E5);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.SE)).hasValue(ChessPosition.E3);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.SW)).hasValue(ChessPosition.C3);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.NW)).hasValue(ChessPosition.C5);

        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.NNE)).hasValue(ChessPosition.E6);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.EEN)).hasValue(ChessPosition.F5);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.EES)).hasValue(ChessPosition.F3);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.SSE)).hasValue(ChessPosition.E2);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.SSW)).hasValue(ChessPosition.C2);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.WWS)).hasValue(ChessPosition.B3);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.WWN)).hasValue(ChessPosition.B5);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.NNW)).hasValue(ChessPosition.C6);
    }

    @Test
    void find() {
        assertThat(ChessPosition.find("a1")).isEqualByComparingTo(ChessPosition.A1);
        assertThat(ChessPosition.find("A1")).isEqualByComparingTo(ChessPosition.A1);
    }

    @Test
    void find_ChessPositionNotFoundException() {
        Exception exception = assertThrows(ChessPositionNotFoundException.class, () -> ChessPosition.find("i1"));

        assertThat(exception.getMessage()).isEqualTo(ChessPositionNotFoundException.CHESS_POSITION_NOT_FOUND_MESSAGE);
    }

    @Test
    void isInitialWhitePawnPosition() {
        assertThat(ChessPosition.A2.isInitialWhitePawnPosition()).isTrue();
        assertThat(ChessPosition.A3.isInitialWhitePawnPosition()).isFalse();
    }

    @Test
    void isInitialBlackPawnPosition() {
        assertThat(ChessPosition.A7.isInitialBlackPawnPosition()).isTrue();
        assertThat(ChessPosition.A6.isInitialBlackPawnPosition()).isFalse();
    }
}