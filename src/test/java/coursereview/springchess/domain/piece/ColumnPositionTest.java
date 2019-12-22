package coursereview.springchess.domain.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static coursereview.springchess.domain.piece.ColumnPosition.*;
import static org.junit.jupiter.api.Assertions.*;

class ColumnPositionTest {

    @DisplayName("String 으로 ColumnPosition 값을 가져올 수 있는지")
    @Test
    void of() {
        assertEquals(ColumnPosition.of("a"), A);
    }

    @DisplayName("ColumnPosition 에 없는 문자열을 입력했을 경우 Exception 이 발생하는지")
    @Test
    void of_exception() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> ColumnPosition.of("i"));
        assertEquals(e.getMessage(), NOT_FOUND_COLUMN_EXCEPTION_MESSAGE);
    }

    @DisplayName("+ 방향으로 다음 Column 이 있는 경우 true 를 리턴하는지")
    @Test
    void hasNext_positive() {
        assertTrue(G.hasNext(1));
    }

    @DisplayName("- 방향으로 다음 Column 이 있는 경우 true 를 리턴하는지")
    @Test
    void hasNext_negative() {
        assertTrue(B.hasNext(-1));
    }

    @DisplayName("+ 방향으로 다음 Column 이 업는 경우 false 를 리턴하는지")
    @Test
    void hasNext_positive_after_h() {
        assertFalse(H.hasNext(1));
    }

    @DisplayName("- 방향으로 다음 Column 이 없는 경우 false 를 리턴하는지")
    @Test
    void hasNext_negative_before_a() {
        assertFalse(A.hasNext(-1));
    }

    @DisplayName("+ 방향으로 다음 Column 을 정상적으로 리턴하는지")
    @Test
    void next_positive() {
        assertEquals(G.next(1), H);
    }

    @DisplayName("- 방향으로 다음 Column 을 정상적으로 리턴하는지")
    @Test
    void next_negative() {
        assertEquals(B.next(-1), A);
    }

    @DisplayName("+ 방향으로 H 의 다음을 호출할 때 에러가 발생하는지")
    @Test
    void next_positive_after_h() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> H.next(1));
        assertEquals(e.getMessage(), COLUMN_BOUND_EXCEPTION_MESSAGE);
    }

    @DisplayName("- 방향으로 A 의 다음을 호출할 때 에러가 발생하는지")
    @Test
    void next_negative_before_a() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> A.next(-1));
        assertEquals(e.getMessage(), COLUMN_BOUND_EXCEPTION_MESSAGE);
    }
}