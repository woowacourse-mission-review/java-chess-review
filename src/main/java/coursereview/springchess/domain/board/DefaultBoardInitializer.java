package coursereview.springchess.domain.board;

import coursereview.springchess.domain.PiecesMapper;
import coursereview.springchess.domain.common.Color;
import coursereview.springchess.domain.piece.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static coursereview.springchess.domain.common.Color.BLACK;
import static coursereview.springchess.domain.common.Color.WHITE;
import static coursereview.springchess.domain.piece.RowPosition.*;
import static coursereview.springchess.domain.piece.Type.*;

public class DefaultBoardInitializer implements BoardInitializer {

    private static final List<Position> EIGHT_ROW_POSITIONS = initializeRowPositions(EIGHT);
    private static final List<Position> SEVEN_ROW_POSITIONS = initializeRowPositions(SEVEN);
    private static final List<Position> TWO_ROW_POSITIONS = initializeRowPositions(TWO);
    private static final List<Position> ONE_ROW_POSITIONS = initializeRowPositions(ONE);

    private static final List<Position> DEFAULT_ROW_POSITIONS =
            Stream.of(EIGHT_ROW_POSITIONS, SEVEN_ROW_POSITIONS, TWO_ROW_POSITIONS, ONE_ROW_POSITIONS)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

    private static final List<Type> PAWNS = Arrays.asList(PAWN, PAWN, PAWN, PAWN, PAWN, PAWN, PAWN, PAWN);
    private static final List<Type> NON_PAWNS = Arrays.asList(ROOK, KNIGHT, BISHOP, QUEEN, KING, BISHOP, KNIGHT, ROOK);

    private static final List<PieceInfo> BLACK_NON_PAWN_PIECE_INFOS = initializePieceInfos(BLACK, NON_PAWNS);
    private static final List<PieceInfo> BLACK_PAWN_PIECE_INFOS = initializePieceInfos(BLACK, PAWNS);
    private static final List<PieceInfo> WHITE_PAWN_PIECE_INFOS = initializePieceInfos(WHITE, PAWNS);
    private static final List<PieceInfo> WHITE_NON_PAWN_PIECE_INFOS = initializePieceInfos(WHITE, NON_PAWNS);

    private static final List<PieceInfo> DEFAULT_PIECE_INFOS =
            Stream.of(BLACK_NON_PAWN_PIECE_INFOS, BLACK_PAWN_PIECE_INFOS, WHITE_PAWN_PIECE_INFOS, WHITE_NON_PAWN_PIECE_INFOS)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

    private static List<Position> initializeRowPositions(RowPosition row) {
        return Arrays.stream(ColumnPosition.values())
                .map(column -> new Position(row, column))
                .collect(Collectors.toList());
    }

    private static List<PieceInfo> initializePieceInfos(final Color color, final List<Type> types) {
        return types.stream()
                .map(type -> new PieceInfo(type, color))
                .collect(Collectors.toList());
    }

    public List<Piece> initialize(Long gameId) {
        return PiecesMapper.toPieces(gameId, DEFAULT_PIECE_INFOS, DEFAULT_ROW_POSITIONS);
    }
}
