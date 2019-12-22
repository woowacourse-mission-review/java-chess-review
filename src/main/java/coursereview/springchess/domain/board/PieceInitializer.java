package coursereview.springchess.domain.board;

import coursereview.springchess.domain.piece.Piece;

import java.util.List;

public interface PieceInitializer {

    List<Piece> initialize(Long gameId);
}
