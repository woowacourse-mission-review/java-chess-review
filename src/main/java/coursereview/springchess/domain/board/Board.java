package coursereview.springchess.domain.board;

import coursereview.springchess.domain.common.Color;
import coursereview.springchess.domain.piece.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

import static coursereview.springchess.domain.piece.Type.KING;
import static coursereview.springchess.domain.piece.Type.PAWN;

public class Board {

    private static final Logger log = LoggerFactory.getLogger(Board.class);
    public static final int DUPLICATE_COUNT = 2;
    public static final int NOT_ENDED_KING_SIZE = 2;

    private final Map<Position, PieceInfo> board;

    public Board(final List<Piece> pieces) {
        board = pieces.stream()
                .collect(Collectors.toMap(Piece::getPosition, Piece::getPieceInfo));
    }

    public void move(final Position from, final Position to) {
        if (!board.containsKey(from)) {
            throw new IllegalArgumentException("이동하려고 하는 말을 찾을 수 없습니다.");
        }
        if (!getMovablePositions(from).contains(to)) {
            throw new IllegalArgumentException("이동할 수 없습니다.");
        }
        board.put(to, board.get(from));
        board.remove(from);
    }

    public Map<Position, List<Position>> calculateMovablePositions(Color turn) {
        Map<Position, List<Position>> movablePositionsMap = new HashMap<>();

        List<Position> positionsWithTurn = getPositionsWithTurn(turn);

        for (Position position : positionsWithTurn) {
            List<Position> movablePositions = getMovablePositions(position);

            movablePositionsMap.put(position, movablePositions);
        }

        return movablePositionsMap;
    }

    private List<Position> getMovablePositions(final Position position) {
        List<List<Position>> candidatesForAllDirections = board.get(position).getMovableCandidatesFor(position);

        return candidatesForAllDirections.stream()
                .map(candidatesForOneDirection -> calculateMovablePositionsForOneDirection(position, candidatesForOneDirection))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    private List<Position> getPositionsWithTurn(final Color turn) {
        return board.entrySet().stream()
                .filter(entry -> entry.getValue().matchColor(turn))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private List<Position> calculateMovablePositionsForOneDirection(Position piecePosition, List<Position> candidatesForOneDirection) {
        List<Position> movablePositions = new ArrayList<>();
        for (Position candidate : candidatesForOneDirection) {
            log.info("piecePosition {}", piecePosition);
            log.info("candidate {}", candidate);
            if (isBlank(candidate)) {
                if (isPawnAttack(piecePosition, candidate)) {
                    break;
                }
                movablePositions.add(candidate);
                continue;
            }
            if (isSameColor(piecePosition, candidate)) {
                break;
            }
            movablePositions.add(candidate);
            break;
        }
        return movablePositions;
    }

    private boolean isBlank(final Position candidate) {
        return !board.containsKey(candidate);
    }

    private boolean isPawnAttack(final Position piecePosition, final Position candidate) {
        return board.get(piecePosition).matchType(PAWN) && !piecePosition.matchColumn(candidate);
    }

    private boolean isSameColor(final Position piecePosition, final Position candidate) {
        return board.get(piecePosition).matchColor(board.get(candidate));
    }

    public double calculateScore(final Color color) {
        return Arrays.stream(ColumnPosition.values())
                .mapToDouble(column -> calculateScoreForColumn(column, color))
                .sum();
    }

    public double calculateScoreForColumn(final ColumnPosition column, final Color color) {
        double scoreExceptPawn = Arrays.stream(RowPosition.values())
                .filter(row -> board.containsKey(new Position(row, column)))
                .map(row -> board.get(new Position(row, column)))
                .filter(piece -> piece.matchColor(color))
                .filter(piece -> !piece.matchType(PAWN))
                .mapToDouble(PieceInfo::getScore)
                .sum();

        long countOfPawn = Arrays.stream(RowPosition.values())
                .filter(row -> board.containsKey(new Position(row, column)))
                .map(row -> board.get(new Position(row, column)))
                .filter(piece -> piece.matchColor(color))
                .filter(piece -> piece.matchType(PAWN))
                .count();

        return scoreExceptPawn + countOfPawn * (countOfPawn >= DUPLICATE_COUNT ? PAWN.getScore() / 2 : PAWN.getScore());
    }

    public boolean isEnded() {
        long countOfKing = board.values().stream()
                .filter(piece -> piece.matchType(KING))
                .count();

        return countOfKing != NOT_ENDED_KING_SIZE;
    }
}
