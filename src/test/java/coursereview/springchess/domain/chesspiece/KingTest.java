package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.player.ChessGamePlayers;
import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class KingTest {

    private ChessGamePlayers chessGamePlayers;

    @BeforeEach
    void setUp() {
        Map<ChessPosition, ChessPiece> currentPieces = new EnumMap<>(ChessPosition.class);
        currentPieces.put(ChessPosition.B1, new Rook());

        Map<ChessPosition, ChessPiece> oppositePieces = new EnumMap<>(ChessPosition.class);
        oppositePieces.put(ChessPosition.A2, new Rook());

        ChessPlayer currentPlayer = new ChessPlayer(currentPieces);
        ChessPlayer oppositePlayer = new ChessPlayer(oppositePieces);

        chessGamePlayers = new ChessGamePlayers(currentPlayer, oppositePlayer);
    }

    @Test
    void findMovablePositions() {
        ChessPiece king = new King();

        ChessPositions movablePositions = king.findMovablePositions(ChessPosition.A1, chessGamePlayers);

        assertThat(movablePositions.size()).isEqualTo(2);
        assertThat(movablePositions.contains(ChessPosition.A2)).isTrue();
        assertThat(movablePositions.contains(ChessPosition.B2)).isTrue();
    }
}