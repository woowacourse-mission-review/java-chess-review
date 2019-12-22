package coursereview.springchess.domain.position;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ChessPositionsTest {

    private List<ChessPosition> positions;

    @BeforeEach
    void setUp() {
        positions = Arrays.asList(ChessPosition.A1, ChessPosition.A2, ChessPosition.A3);
    }

    @Test
    void contains_and_size() {
        ChessPositions chessPositions = new ChessPositions(positions);

        assertThat(chessPositions.size()).isEqualTo(3);
        assertThat(chessPositions.contains(ChessPosition.A1)).isTrue();
        assertThat(chessPositions.contains(ChessPosition.A2)).isTrue();
        assertThat(chessPositions.contains(ChessPosition.A3)).isTrue();
    }
}