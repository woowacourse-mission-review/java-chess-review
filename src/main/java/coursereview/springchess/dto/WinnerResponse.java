package coursereview.springchess.dto;

public class WinnerResponse {

    private String winner;

    public WinnerResponse(final String winner) {
        this.winner = winner;
    }

    public String getWinner() {
        return winner;
    }
}
