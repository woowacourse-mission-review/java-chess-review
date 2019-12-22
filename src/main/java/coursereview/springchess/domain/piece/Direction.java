package coursereview.springchess.domain.piece;

import coursereview.springchess.domain.common.Color;

import java.util.Arrays;
import java.util.List;

import static coursereview.springchess.domain.common.Color.WHITE;

public enum Direction {

    NW(-1, 1),
    N(0, 1),
    NE(1, 1),
    E(1, 0),
    SE(1, -1),
    S(0, -1),
    SW(-1, -1),
    W(-1, 0),
    SSE(1, -2),
    SSW(-1, -2),
    SEE(2, -1),
    SWW(-2, -1),
    NNE(1, 2),
    NNW(-1, 2),
    NEE(2, 1),
    NWW(-2, 1);

    private int columnShiftUnit;
    private int rowShiftUnit;

    Direction(int columnShiftUnit, int rowShiftUnit) {
        this.rowShiftUnit = rowShiftUnit;
        this.columnShiftUnit = columnShiftUnit;
    }

    public int getColumnShiftUnit() {
        return columnShiftUnit;
    }

    public int getRowShiftUnit() {
        return rowShiftUnit;
    }

    public static List<Direction> valueOfDiagonal() {
        return Arrays.asList(NE, NW, SE, SW);
    }

    public static List<Direction> valueOfOrthogonal() {
        return Arrays.asList(N, E, W, S);
    }

    public static List<Direction> valueOfKnight() {
        return Arrays.asList(NEE, NWW, SEE, SWW, SSE, SSW, NNW, NNE);
    }

    public static Direction valueOfPawnMove(Color turn) {
        return turn == WHITE ? N : S;
    }

    public static List<Direction> valueOfPawnAttack(Color turn) {
        return turn == WHITE ? Arrays.asList(NE, NW) : Arrays.asList(SE, SW);
    }
}
