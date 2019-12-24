package coursereview.springchess.domain.chesspiece.pawn;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.chesspiece.Rook;
import coursereview.springchess.domain.player.ChessGamePlayers;
import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BlackPawnTest {

    private ChessGamePlayers chessGamePlayers;

    @BeforeEach
    void setUp() {
        Map<ChessPosition, ChessPiece> currentPieces = new EnumMap<>(ChessPosition.class);

        Map<ChessPosition, ChessPiece> oppositePieces = new EnumMap<>(ChessPosition.class);
        oppositePieces.put(ChessPosition.C6, new Rook());

        ChessPlayer currentPlayer = new ChessPlayer(currentPieces);
        ChessPlayer oppositePlayer = new ChessPlayer(oppositePieces);

        chessGamePlayers = new ChessGamePlayers(currentPlayer, oppositePlayer);
    }

    @Test
    void findMovablePositions() {
        ChessPiece blackPawn = new BlackPawn();

        ChessPositions movablePositions = blackPawn.findMovablePositions(ChessPosition.B7, chessGamePlayers);

        assertThat(movablePositions.size()).isEqualTo(3);
        assertThat(movablePositions.contains(ChessPosition.B6)).isTrue();
        assertThat(movablePositions.contains(ChessPosition.B5)).isTrue();
        assertThat(movablePositions.contains(ChessPosition.C6)).isTrue();

        ChessPositions movablePositions2 = blackPawn.findMovablePositions(ChessPosition.B6, chessGamePlayers);

        assertThat(movablePositions2.size()).isEqualTo(1);
        assertThat(movablePositions2.contains(ChessPosition.B5)).isTrue();
    }
}