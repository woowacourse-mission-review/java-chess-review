package coursereview.springchess.domain.player;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.chesspiece.pawn.AbstractPawn;
import coursereview.springchess.domain.exception.CannotMovablePositionException;
import coursereview.springchess.domain.exception.ChessPieceNotFoundOnSourceException;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.MovablePositions;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ChessPlayer {

    protected Map<ChessPosition, ChessPiece> pieces;

    public ChessPlayer() {
        this.pieces = new EnumMap<>(ChessPosition.class);
    }

    public ChessPlayer(final Map<ChessPosition, ChessPiece> pieces) {
        this.pieces = pieces;
    }

    public boolean contains(final ChessPosition chessPosition) {
        return pieces.containsKey(chessPosition);
    }

    public boolean doesNotContain(final ChessPosition chessPosition) {
        return !contains(chessPosition);
    }

    public MovablePositions findMovablePositions(final ChessPlayer oppositePlayer) {
        Map<ChessPosition, ChessPositions> positions = new EnumMap<>(ChessPosition.class);
        ChessGamePlayers chessGamePlayers = new ChessGamePlayers(this, oppositePlayer);

        pieces.forEach((key, value) -> {
            ChessPositions movablePositions = value.findMovablePositions(key, chessGamePlayers);
            positions.put(key, movablePositions);
        });
        return new MovablePositions(positions);
    }

    public void move(final ChessPosition source, final ChessPosition target, final ChessPlayer oppositePlayer) {
        if (doesNotContain(source)) {
            throw new ChessPieceNotFoundOnSourceException();
        }

        MovablePositions movablePositions = findMovablePositions(oppositePlayer);
        if (movablePositions.doesNotHaveMovementAbout(source, target)) {
            throw new CannotMovablePositionException();
        }

        moveChessPiece(source, target);
        removeEnemy(target, oppositePlayer);
    }

    private void moveChessPiece(final ChessPosition source, final ChessPosition target) {
        ChessPiece chessPiece = pieces.remove(source);
        pieces.put(target, chessPiece);
    }

    private void removeEnemy(final ChessPosition target, final ChessPlayer oppositePlayer) {
        if (oppositePlayer.contains(target)) {
            oppositePlayer.pieces.remove(target);
        }
    }

    public Map<ChessPosition, ChessPiece> getPieces() {
        return pieces;
    }

    public double calculateScore() {
        double totalScore = calculateTotalScore();

        Map<String, Integer> pawnCountsByWidthPositions = countPawnsByWidthPositions();
        int size = countSameWidthPositionPawns(pawnCountsByWidthPositions);

        return totalScore - size * AbstractPawn.getDeductionScore();
    }

    private double calculateTotalScore() {
        return pieces.values().stream()
                .map(ChessPiece::getScore)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    private Map<String, Integer> countPawnsByWidthPositions() {
        Map<String, Integer> pawnCountsByWidthPositions = new HashMap<>();
        pieces.entrySet().stream()
                .filter(entry -> entry.getValue().isPawn())
                .map(entry -> entry.getKey().getWidthPosition())
                .forEach(widthPosition -> increaseCount(pawnCountsByWidthPositions, widthPosition));
        return pawnCountsByWidthPositions;
    }

    private void increaseCount(final Map<String, Integer> widthPositionCounts, final String widthPosition) {
        Integer count = widthPositionCounts.get(widthPosition);

        count = Objects.isNull(count) ? 1 : count + 1;
        widthPositionCounts.put(widthPosition, count);
    }

    private int countSameWidthPositionPawns(final Map<String, Integer> pawnCountsByWidthPositions) {
        return pawnCountsByWidthPositions.values().stream()
                .filter(count -> count > 1)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public boolean isKingAlive() {
        return pieces.values().stream()
                .anyMatch(ChessPiece::isKing);
    }
}
