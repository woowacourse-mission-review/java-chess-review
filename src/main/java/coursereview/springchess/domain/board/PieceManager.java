package coursereview.springchess.domain.board;

import coursereview.springchess.domain.piece.Piece;

import java.util.List;

public class PieceManager {

    private PieceInitializer pieceInitializer;

    public PieceManager(final PieceInitializer pieceInitializer) {
        this.pieceInitializer = pieceInitializer;
    }

    public List<Piece> initializePieces(Long gameId) {
        return pieceInitializer.initialize(gameId);
    }
}
