package coursereview.springchess.domain;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.chesspiece.King;
import coursereview.springchess.domain.chesspiece.Rook;
import coursereview.springchess.domain.exception.AlreadyChessGameIsOverException;
import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ChessGameTest {

    private ChessPlayer whitePlayer;
    private ChessPlayer blackPlayer;

    @BeforeEach
    void setUp() {
        Map<ChessPosition, ChessPiece> currentPieces = new EnumMap<>(ChessPosition.class);
        currentPieces.put(ChessPosition.E8, new King());

        Map<ChessPosition, ChessPiece> oppositePieces = new EnumMap<>(ChessPosition.class);
        oppositePieces.put(ChessPosition.D6, new Rook());

        whitePlayer = new ChessPlayer(currentPieces);
        blackPlayer = new ChessPlayer(oppositePieces);
    }

    @Test
    void move() {
        ChessGame chessGame = new ChessGame(whitePlayer, blackPlayer, true);
        assertThrows(AlreadyChessGameIsOverException.class, () -> chessGame.move(ChessPosition.E8, ChessPosition.E7));
    }
}