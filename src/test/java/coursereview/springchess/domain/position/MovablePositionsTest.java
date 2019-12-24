package coursereview.springchess.domain.position;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MovablePositionsTest {

    private Map<ChessPosition, ChessPositions> positions;

    @BeforeEach
    void setUp() {
        positions = new EnumMap<>(ChessPosition.class);
        positions.put(ChessPosition.D4
                , new ChessPositions(Arrays.asList(ChessPosition.D5, ChessPosition.D6, ChessPosition.D7, ChessPosition.D8)));
    }

    @Test
    void hasMovementAbout() {
        MovablePositions movablePositions = new MovablePositions(positions);

        assertThat(movablePositions.hasMovementAbout(ChessPosition.D4, ChessPosition.D5)).isTrue();

        assertThat(movablePositions.hasMovementAbout(ChessPosition.D4, ChessPosition.D3)).isFalse();
        assertThat(movablePositions.hasMovementAbout(ChessPosition.E4, ChessPosition.D5)).isFalse();
    }
}