package coursereview.springchess.domain.player;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.chesspiece.Rook;
import coursereview.springchess.domain.exception.CannotMovablePositionException;
import coursereview.springchess.domain.exception.ChessPieceNotFoundOnSourceException;
import coursereview.springchess.domain.position.ChessPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ChessPlayerTest {

    private Map<ChessPosition, ChessPiece> currentPieces;
    private Map<ChessPosition, ChessPiece> oppositePieces;

    @BeforeEach
    void setUp() {
        currentPieces = new EnumMap<>(ChessPosition.class);
        currentPieces.put(ChessPosition.D4, new Rook());

        oppositePieces = new EnumMap<>(ChessPosition.class);
        oppositePieces.put(ChessPosition.D6, new Rook());
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

    @Test
    void move() {
        ChessPlayer currentPlayer = new ChessPlayer(currentPieces);
        ChessPlayer oppositePlayer = new ChessPlayer(oppositePieces);

        assertThat(currentPlayer.contains(ChessPosition.D6)).isFalse();
        assertThat(oppositePlayer.contains(ChessPosition.D6)).isTrue();

        currentPlayer.move(ChessPosition.D4, ChessPosition.D6, oppositePlayer);

        assertThat(currentPlayer.contains(ChessPosition.D4)).isFalse();
        assertThat(currentPlayer.contains(ChessPosition.D6)).isTrue();
        assertThat(oppositePlayer.contains(ChessPosition.D6)).isFalse();
    }

    @Test
    void move_ChessPieceNotFoundOnSourceException() {
        ChessPlayer currentPlayer = new ChessPlayer(currentPieces);
        ChessPlayer oppositePlayer = new ChessPlayer(oppositePieces);

        Exception exception = assertThrows(ChessPieceNotFoundOnSourceException.class
                , () -> currentPlayer.move(ChessPosition.D5, ChessPosition.D6, oppositePlayer));

        assertThat(exception.getMessage()).isEqualTo(ChessPieceNotFoundOnSourceException.CHESS_PIECE_NOT_FOUND_ON_SOURCE_MESSAGE);
    }

    @Test
    void move_CannotMovablePositionException() {
        ChessPlayer currentPlayer = new ChessPlayer(currentPieces);
        ChessPlayer oppositePlayer = new ChessPlayer(oppositePieces);

        Exception exception = assertThrows(CannotMovablePositionException.class
                , () -> currentPlayer.move(ChessPosition.D4, ChessPosition.D7, oppositePlayer));

        assertThat(exception.getMessage()).isEqualTo(CannotMovablePositionException.CANNOT_MOVABLE_POSITION_MESSAGE);
    }
}