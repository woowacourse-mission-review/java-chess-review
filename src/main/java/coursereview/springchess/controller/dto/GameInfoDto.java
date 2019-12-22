package coursereview.springchess.controller.dto;

import coursereview.springchess.domain.common.Color;
import coursereview.springchess.domain.game.GameStatus;
import coursereview.springchess.domain.piece.Piece;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
public class GameInfoDto {

    private String turn;
    private Double scoreWhite;
    private Double scoreBlack;
    private String gameStatus;
    private Map<String, String> positionsOfPieces;

    public GameInfoDto(final Color turn, final Double scoreWhite, final Double scoreBlack,
                       final GameStatus gameStatus, final List<Piece> pieces) {
        this.turn = turn.name().toLowerCase();
        this.scoreWhite = scoreWhite;
        this.scoreBlack = scoreBlack;
        this.gameStatus = gameStatus.getSign();
        positionsOfPieces = pieces.stream()
                .collect(Collectors.toMap(piece -> piece.getColumn().getColumn() + piece.getRow().getRow(),
                        piece -> piece.getColor().getSign() + piece.getType().getSign()));
    }
}
