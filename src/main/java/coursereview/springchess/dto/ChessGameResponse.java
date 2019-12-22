package coursereview.springchess.dto;

import java.util.Map;

public class ChessGameResponse {

    private final Map<String, String> positionsOfPieces;
    private final String turn;
    private final double scoreWhite;
    private final double scoreBlack;
    private final String gameStatus;

    public ChessGameResponse(final Map<String, String> positionsOfPieces, final String turn, final double scoreWhite
            , final double scoreBlack, final String gameStatus) {
        this.positionsOfPieces = positionsOfPieces;
        this.turn = turn;
        this.scoreWhite = scoreWhite;
        this.scoreBlack = scoreBlack;
        this.gameStatus = gameStatus;
    }

    public Map<String, String> getPositionsOfPieces() {
        return positionsOfPieces;
    }

    public String getTurn() {
        return turn;
    }

    public double getScoreWhite() {
        return scoreWhite;
    }

    public double getScoreBlack() {
        return scoreBlack;
    }

    public String getGameStatus() {
        return gameStatus;
    }
}
