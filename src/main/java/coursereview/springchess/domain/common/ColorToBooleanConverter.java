package coursereview.springchess.domain.common;

import javax.persistence.AttributeConverter;

import static coursereview.springchess.domain.common.Color.BLACK;
import static coursereview.springchess.domain.common.Color.WHITE;

public class ColorToBooleanConverter implements AttributeConverter<Color, Boolean> {

    @Override
    public Boolean convertToDatabaseColumn(final Color color) {
        return WHITE.equals(color);
    }

    @Override
    public Color convertToEntityAttribute(final Boolean dbData) {
        return dbData ? WHITE : BLACK;
    }
}
