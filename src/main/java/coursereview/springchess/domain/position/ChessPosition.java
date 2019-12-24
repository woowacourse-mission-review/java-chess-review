package coursereview.springchess.domain.position;

import coursereview.springchess.domain.exception.ChessPositionNotFoundException;

import java.util.Arrays;
import java.util.Optional;

public enum ChessPosition {
    A1("a1"), A2("a2"), A3("a3"), A4("a4"), A5("a5"), A6("a6"), A7("a7"), A8("a8"),
    B1("b1"), B2("b2"), B3("b3"), B4("b4"), B5("b5"), B6("b6"), B7("b7"), B8("b8"),
    C1("c1"), C2("c2"), C3("c3"), C4("c4"), C5("c5"), C6("c6"), C7("c7"), C8("c8"),
    D1("d1"), D2("d2"), D3("d3"), D4("d4"), D5("d5"), D6("d6"), D7("d7"), D8("d8"),
    E1("e1"), E2("e2"), E3("e3"), E4("e4"), E5("e5"), E6("e6"), E7("e7"), E8("e8"),
    F1("f1"), F2("f2"), F3("f3"), F4("f4"), F5("f5"), F6("f6"), F7("f7"), F8("f8"),
    G1("g1"), G2("g2"), G3("g3"), G4("g4"), G5("g5"), G6("g6"), G7("g7"), G8("g8"),
    H1("h1"), H2("h2"), H3("h3"), H4("h4"), H5("h5"), H6("h6"), H7("h7"), H8("h8");

    private static final int INDEX_OF_WIDTH_POSITION = 0;
    private static final int INDEX_OF_HEIGHT_POSITION = 1;
    private static final String LINE_OF_WHITE_PAWN = "2";
    private static final String LINE_OF_BLACK_PAWN = "7";

    private final String position;

    ChessPosition(final String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public Optional<ChessPosition> moveAdjacentPositionBy(final Direction direction) {
        try {
            final char nextX = moveToNext(INDEX_OF_WIDTH_POSITION, direction.getXDegree());
            final char nextY = moveToNext(INDEX_OF_HEIGHT_POSITION, direction.getYDegree());

            final String positionName = String.valueOf(nextX) + nextY;
            return Optional.ofNullable(find(positionName));
        } catch (ChessPositionNotFoundException e) {
            return Optional.empty();
        }
    }

    private char moveToNext(final int indexOfPosition, final int degree) {
        return (char) (position.charAt(indexOfPosition) + degree);
    }

    public static ChessPosition find(final String position) {
        return Arrays.stream(values())
                .filter(chessPosition -> chessPosition.position.equalsIgnoreCase(position))
                .findFirst()
                .orElseThrow(ChessPositionNotFoundException::new);
    }

    public boolean isInitialWhitePawnPosition() {
        return LINE_OF_WHITE_PAWN.equals(String.valueOf(position.charAt(INDEX_OF_HEIGHT_POSITION)));
    }

    public boolean isInitialBlackPawnPosition() {
        return LINE_OF_BLACK_PAWN.equals(String.valueOf(position.charAt(INDEX_OF_HEIGHT_POSITION)));
    }
}