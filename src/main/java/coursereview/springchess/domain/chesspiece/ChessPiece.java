package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;

public interface ChessPiece {
    ChessPositions findMovablePositions(final ChessPosition source, final ChessPlayer currentPlayer, final ChessPlayer oppositePlayer);

    String getSign();
}
