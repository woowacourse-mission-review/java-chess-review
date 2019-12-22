package coursereview.springchess.domain.board;

import coursereview.springchess.domain.piece.Piece;

import java.util.List;

public interface BoardInitializer {

    List<Piece> initialize(Long gameId);
}
