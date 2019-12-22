package coursereview.springchess.domain.game;

import coursereview.springchess.domain.common.Color;
import coursereview.springchess.domain.common.ColorToBooleanConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static coursereview.springchess.domain.common.Color.WHITE;
import static coursereview.springchess.domain.game.GameStatus.BATTLE;
import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@Entity
@Getter
@ToString
public class ChessGame {

    private static final Integer DEFAULT_SCORE = 38;

    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "turn", nullable = false, columnDefinition = "boolean default true")
    @Convert(converter = ColorToBooleanConverter.class)
    private Color turn;

    @Column(name = "scoreWhite", nullable = false, columnDefinition = "integer default 38")
    private Integer scoreWhite;

    @Column(name = "scoreBlack", nullable = false, columnDefinition = "integer default 38")
    private Integer scoreBlack;

    @Column(name = "gameStatus", nullable = false, columnDefinition = "boolean default true")
    @Convert(converter = GameStatusToBooleanConverter.class)
    private GameStatus gameStatus;

    @PrePersist
    public void prePersist() {
        turn = (turn == null) ? WHITE : turn;
        scoreWhite = (scoreWhite == null) ? DEFAULT_SCORE : scoreWhite;
        scoreBlack = (scoreBlack == null) ? DEFAULT_SCORE : scoreBlack;
        gameStatus = (gameStatus == null) ? BATTLE : gameStatus;
    }
}
