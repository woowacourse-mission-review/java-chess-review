package coursereview.springchess.domain.player;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.chesspiece.Rook;
import coursereview.springchess.domain.position.ChessPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ChessPlayerTest {

    private Map<ChessPosition, ChessPiece> currentPieces;

    @BeforeEach
    void setUp() {
        currentPieces = new EnumMap<>(ChessPosition.class);
        currentPieces.put(ChessPosition.D4, new Rook());
    }

    @Test
    void contains() {
        ChessPlayer currentPlayer = new ChessPlayer(currentPieces);

        assertThat(currentPlayer.contains(ChessPosition.D4)).isTrue();
    }

    @Test
    void doesNotContain() {
        ChessPlayer currentPlayer = new ChessPlayer(currentPieces);

        assertThat(currentPlayer.doesNotContain(ChessPosition.D5)).isTrue();
    }
}