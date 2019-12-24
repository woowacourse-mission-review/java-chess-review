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

class BishopTest {

    private ChessGamePlayers chessGamePlayers;

    @BeforeEach
    void setUp() {
        Map<ChessPosition, ChessPiece> currentPieces = new EnumMap<>(ChessPosition.class);
        currentPieces.put(ChessPosition.A1, new Rook());

        Map<ChessPosition, ChessPiece> oppositePieces = new EnumMap<>(ChessPosition.class);
        oppositePieces.put(ChessPosition.C3, new Rook());

        ChessPlayer currentPlayer = new ChessPlayer(currentPieces);
        ChessPlayer oppositePlayer = new ChessPlayer(oppositePieces);

        chessGamePlayers = new ChessGamePlayers(currentPlayer, oppositePlayer);
    }

    @Test
    void findMovablePositions() {
        ChessPiece bishop = new Bishop();

        ChessPositions movablePositions = bishop.findMovablePositions(ChessPosition.B2, chessGamePlayers);

        assertThat(movablePositions.size()).isEqualTo(3);
        assertThat(movablePositions.contains(ChessPosition.A3)).isTrue();
        assertThat(movablePositions.contains(ChessPosition.C3)).isTrue();
        assertThat(movablePositions.contains(ChessPosition.C1)).isTrue();
    }
}