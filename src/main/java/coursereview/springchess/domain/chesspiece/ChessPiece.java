package coursereview.springchess.domain.chesspiece;

import coursereview.springchess.domain.player.ChessGamePlayers;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;

public interface ChessPiece {
    ChessPositions findMovablePositions(final ChessPosition source, final ChessGamePlayers chessGamePlayers);

    boolean canMoveSeveralPositions();

    boolean isPawn();

    boolean isKing();

    String getSign();

    double getScore();
}
