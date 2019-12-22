package coursereview.springchess.domain.board;

import coursereview.springchess.domain.common.Color;
import coursereview.springchess.domain.piece.Piece;
import coursereview.springchess.domain.piece.PieceInfo;
import coursereview.springchess.domain.piece.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

import static coursereview.springchess.domain.piece.Type.PAWN;

public class Board {

    private static final Logger log = LoggerFactory.getLogger(Board.class);

    private final Map<Position, PieceInfo> board;

    public Board(final List<Piece> pieces) {
        board = pieces.stream()
                .collect(Collectors.toMap(Piece::getPosition, Piece::getPieceInfo));
    }

    public Map<Position, List<Position>> calculateMovablePositions(Color turn) {
        Map<Position, List<Position>> movablePositionsMap = new HashMap<>();

        List<Position> positionsWithTurn = getPositionsWithTurn(turn);

        for (Position position : positionsWithTurn) {
            List<List<Position>> candidatesForAllDirections = board.get(position).getMovableCandidatesFor(position);

            List<Position> movablePositions = candidatesForAllDirections.stream()
                    .map(candidatesForOneDirection -> calculateMovablePositionsForOneDirection(position, candidatesForOneDirection))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());

            movablePositionsMap.put(position, movablePositions);
        }

        return movablePositionsMap;
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
}
