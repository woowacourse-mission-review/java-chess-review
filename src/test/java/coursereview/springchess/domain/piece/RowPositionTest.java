package coursereview.springchess.domain.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coursereview.springchess.domain.piece.RowPosition.*;
import static org.junit.jupiter.api.Assertions.*;

class RowPositionTest {

    @DisplayName("String 으로 RowPosition 값을 가져올 수 있는지")
    @Test
    void of() {
        assertEquals(RowPosition.of("1"), RowPosition.ONE);
    }

    @DisplayName("RowPosition 에 없는 문자열을 입력했을 경우 Exception 이 발생하는지")
    @Test
    void of_exception() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> RowPosition.of("0"));
        assertEquals(e.getMessage(), NOT_FOUND_ROW_EXCEPTION_MESSAGE);
    }

    @DisplayName("+ 방향으로 다음 Row 이 있는 경우 true 를 리턴하는지")
    @Test
    void hasNext_positive() {
        assertTrue(SEVEN.hasNext(1));
    }

    @DisplayName("- 방향으로 다음 Row 이 있는 경우 true 를 리턴하는지")
    @Test
    void hasNext_negative() {
        assertTrue(TWO.hasNext(-1));
    }

    @DisplayName("+ 방향으로 다음 Row 이 업는 경우 false 를 리턴하는지")
    @Test
    void hasNext_positive_after_h() {
        assertFalse(EIGHT.hasNext(1));
    }

    @DisplayName("- 방향으로 다음 Row 이 없는 경우 false 를 리턴하는지")
    @Test
    void hasNext_negative_before_a() {
        assertFalse(ONE.hasNext(-1));
    }

    @DisplayName("+ 방향으로 다음 Row 을 정상적으로 리턴하는지")
    @Test
    void next_positive() {
        assertEquals(SEVEN.next(1), EIGHT);
    }

    @DisplayName("- 방향으로 다음 Row 을 정상적으로 리턴하는지")
    @Test
    void next_negative() {
        assertEquals(TWO.next(-1), ONE);
    }

    @DisplayName("+ 방향으로 8 의 다음을 호출할 때 에러가 발생하는지")
    @Test
    void next_positive_after_h() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> EIGHT.next(1));
        assertEquals(e.getMessage(), ROW_BOUND_EXCEPTION_MESSAGE);
    }

    @DisplayName("- 방향으로 1 의 다음을 호출할 때 에러가 발생하는지")
    @Test
    void next_negative_before_a() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> ONE.next(-1));
        assertEquals(e.getMessage(), ROW_BOUND_EXCEPTION_MESSAGE);
    }
}