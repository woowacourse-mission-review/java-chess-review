package coursereview.springchess.domain;

import coursereview.springchess.domain.piece.Piece;
import coursereview.springchess.domain.piece.PieceInfo;
import coursereview.springchess.domain.piece.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PiecesMapper {

    private static final int BASE_INDEX = 0;

    public static List<Piece> toPieces(Long gameId, List<PieceInfo> pieceInfos, List<Position> positions) {
        return IntStream.range(BASE_INDEX, pieceInfos.size())
                .mapToObj(index -> new Piece(gameId, pieceInfos.get(index), positions.get(index)))
                .collect(Collectors.toList());
    }
}
