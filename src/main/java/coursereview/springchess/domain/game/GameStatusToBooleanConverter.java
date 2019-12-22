package coursereview.springchess.domain.game;

import javax.persistence.AttributeConverter;

import static coursereview.springchess.domain.game.GameStatus.BATTLE;
import static coursereview.springchess.domain.game.GameStatus.END;

public class GameStatusToBooleanConverter implements AttributeConverter<GameStatus, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(final GameStatus gameStatus) {
        return BATTLE.equals(gameStatus);
    }

    @Override
    public GameStatus convertToEntityAttribute(final Boolean dbData) {
        return dbData ? BATTLE : END;
    }
}
