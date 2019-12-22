package coursereview.springchess.domain.board;

import coursereview.springchess.domain.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final List<Piece> pieces;

    public Board(final List<Piece> pieces) {
        this.pieces = pieces;
    }

    public List<Piece> getPieces() {
        return new ArrayList<>(pieces);
    }
}
