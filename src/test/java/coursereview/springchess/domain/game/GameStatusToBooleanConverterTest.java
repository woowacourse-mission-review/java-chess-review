package coursereview.springchess.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coursereview.springchess.domain.game.GameStatus.BATTLE;
import static coursereview.springchess.domain.game.GameStatus.END;
import static org.junit.jupiter.api.Assertions.*;

class GameStatusToBooleanConverterTest {

    private final GameStatusToBooleanConverter converter = new GameStatusToBooleanConverter();

    @DisplayName("GameStatus BATTLE 이 True 로 바뀌는지")
    @Test
    void battle_to_true() {
        assertTrue(converter.convertToDatabaseColumn(BATTLE));
    }

    @DisplayName("GameStatus END 가 False 로 바뀌는지")
    @Test
    void end_to_false() {
        assertFalse(converter.convertToDatabaseColumn(END));
    }

    @DisplayName("데이터베이스의 True 가 GameStatus BATTLE 로 바뀌는지")
    @Test
    void true_to_battle() {
        assertEquals(converter.convertToEntityAttribute(true), BATTLE);
    }

    @DisplayName("데이터베이스의 False 가 GameStatus END 로 바뀌는지")
    @Test
    void false_to_end() {
        assertEquals(converter.convertToEntityAttribute(false), END);
    }
}