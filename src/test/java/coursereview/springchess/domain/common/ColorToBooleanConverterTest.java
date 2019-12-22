package coursereview.springchess.domain.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coursereview.springchess.domain.common.Color.BLACK;
import static coursereview.springchess.domain.common.Color.WHITE;
import static org.junit.jupiter.api.Assertions.*;

class ColorToBooleanConverterTest {

    private final ColorToBooleanConverter converter = new ColorToBooleanConverter();

    @DisplayName("Color WHITE  True 로 바뀌는지")
    @Test
    void white_to_true() {
        assertTrue(converter.convertToDatabaseColumn(WHITE));
    }

    @DisplayName("Color BLACK 이 False 로 바뀌는지")
    @Test
    void black_to_false() {
        assertFalse(converter.convertToDatabaseColumn(BLACK));
    }

    @DisplayName("데이터베이스의 True 가 Color WHITE 로 바뀌는지")
    @Test
    void true_to_white() {
        assertEquals(converter.convertToEntityAttribute(true), WHITE);
    }

    @DisplayName("데이터베이스의 False 가 Color BLACK 으로 바뀌는지")
    @Test
    void false_to_black() {
        assertEquals(converter.convertToEntityAttribute(false), BLACK);
    }
}