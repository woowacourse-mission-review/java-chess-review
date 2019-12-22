package coursereview.springchess.domain.board;

import coursereview.springchess.domain.piece.Piece;

import java.util.List;

public class BoardManager {

    private BoardInitializer boardInitializer;

    public BoardManager(final BoardInitializer boardInitializer) {
        this.boardInitializer = boardInitializer;
    }

    public Board initializeBoard(Long gameId) {
        return new Board(boardInitializer.initialize(gameId));
    }

    public Board convertToBoard(List<Piece> pieces) {
        return new Board(pieces);
    }
}
