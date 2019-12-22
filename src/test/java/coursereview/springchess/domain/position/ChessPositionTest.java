package coursereview.springchess.domain.position;

import coursereview.springchess.domain.exception.ChessPositionNotFoundException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChessPositionTest {

    @Test
    void moveAdjacentPositionBy() {
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.N)).isEqualByComparingTo(ChessPosition.D5);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.E)).isEqualByComparingTo(ChessPosition.E4);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.S)).isEqualByComparingTo(ChessPosition.D3);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.W)).isEqualByComparingTo(ChessPosition.C4);

        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.NE)).isEqualByComparingTo(ChessPosition.E5);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.SE)).isEqualByComparingTo(ChessPosition.E3);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.SW)).isEqualByComparingTo(ChessPosition.C3);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.NW)).isEqualByComparingTo(ChessPosition.C5);

        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.NNE)).isEqualByComparingTo(ChessPosition.E6);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.EEN)).isEqualByComparingTo(ChessPosition.F5);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.EES)).isEqualByComparingTo(ChessPosition.F3);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.SSE)).isEqualByComparingTo(ChessPosition.E2);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.SSW)).isEqualByComparingTo(ChessPosition.C2);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.WWS)).isEqualByComparingTo(ChessPosition.B3);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.WWN)).isEqualByComparingTo(ChessPosition.B5);
        assertThat(ChessPosition.D4.moveAdjacentPositionBy(Direction.NNW)).isEqualByComparingTo(ChessPosition.C6);
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
}