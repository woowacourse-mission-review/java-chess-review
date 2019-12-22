package coursereview.springchess.controller.dto;

import coursereview.springchess.domain.common.Color;
import lombok.Getter;

@Getter
public class WinnerDto {

    private String winner;

    public WinnerDto(final Color winner) {
        this.winner = winner.name().toLowerCase();
    }
}
