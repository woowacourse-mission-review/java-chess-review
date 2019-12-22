package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RookTest {

    private ChessPlayer currentPlayer;
    private ChessPlayer oppositePlayer;

    @BeforeEach
    void setUp() {
        Map<ChessPosition, ChessPiece> currentPieces = new EnumMap<>(ChessPosition.class);
        currentPieces.put(ChessPosition.C1, new Rook());

        Map<ChessPosition, ChessPiece> oppositePieces = new EnumMap<>(ChessPosition.class);
        oppositePieces.put(ChessPosition.A3, new Rook());

        currentPlayer = new ChessPlayer(currentPieces);
        oppositePlayer = new ChessPlayer(oppositePieces);
    }

    @Test
    void findMovablePositions() {
        ChessPiece rook = new Rook();

        ChessPositions movablePositions = rook.findMovablePositions(ChessPosition.A1, currentPlayer, oppositePlayer);

        assertThat(movablePositions.size()).isEqualTo(3);
        assertThat(movablePositions.contains(ChessPosition.A2)).isTrue();
        assertThat(movablePositions.contains(ChessPosition.A3)).isTrue();
        assertThat(movablePositions.contains(ChessPosition.B1)).isTrue();
    }
}