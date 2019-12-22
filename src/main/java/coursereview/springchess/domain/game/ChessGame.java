package coursereview.springchess.domain.game;

import coursereview.springchess.domain.common.Color;
import coursereview.springchess.domain.common.ColorToBooleanConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static coursereview.springchess.domain.common.Color.BLACK;
import static coursereview.springchess.domain.common.Color.WHITE;
import static coursereview.springchess.domain.game.GameStatus.BATTLE;
import static coursereview.springchess.domain.game.GameStatus.END;
import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@Entity
@Getter
@ToString
public class ChessGame {

    private static final Double DEFAULT_SCORE = 38.0;

    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "turn", nullable = false, columnDefinition = "boolean default true")
    @Convert(converter = ColorToBooleanConverter.class)
    private Color turn;

    @Column(name = "scoreWhite", nullable = false, columnDefinition = "double default 38.0")
    private Double scoreWhite;

    @Column(name = "scoreBlack", nullable = false, columnDefinition = "double default 38.0")
    private Double scoreBlack;

    @Column(name = "gameStatus", nullable = false, columnDefinition = "boolean default true")
    @Convert(converter = GameStatusToBooleanConverter.class)
    private GameStatus gameStatus;

    public void changeTurn(final double scoreWhite, final double scoreBlack, final boolean isEnded) {
        turn = (turn.equals(BLACK)) ? WHITE : BLACK;
        this.scoreWhite = scoreWhite;
        this.scoreBlack = scoreBlack;
        this.gameStatus = isEnded ? END : BATTLE;
    }

    @PrePersist
    public void prePersist() {
        turn = (turn == null) ? WHITE : turn;
        scoreWhite = (scoreWhite == null) ? DEFAULT_SCORE : scoreWhite;
        scoreBlack = (scoreBlack == null) ? DEFAULT_SCORE : scoreBlack;
        gameStatus = (gameStatus == null) ? BATTLE : gameStatus;
    }
}
