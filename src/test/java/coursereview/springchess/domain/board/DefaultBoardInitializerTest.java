package coursereview.springchess.domain.board;

import coursereview.springchess.domain.piece.Piece;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultBoardInitializerTest {

    private DefaultBoardInitializer defaultBoardInitializer = new DefaultBoardInitializer();

    @DisplayName("초기화 테스트")
    @Test
    void initialize() {
        List<Piece> pieces = defaultBoardInitializer.initialize(1L);

        assertThat(pieces).hasSize(32);
    }
}