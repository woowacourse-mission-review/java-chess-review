package coursereview.springchess.domain.piece;

import coursereview.springchess.domain.common.Color;
import coursereview.springchess.domain.common.ColorToBooleanConverter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;

@Embeddable
@ToString
public class PieceInfo {

    @Column(name = "type", nullable = false)
    private Type type;

    @Column(name = "color", nullable = false)
    @Convert(converter = ColorToBooleanConverter.class)
    private Color color;

    private PieceInfo() {
    }

    public PieceInfo(final Type type, final Color color) {
        this.type = type;
        this.color = color;
    }

    public Type getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
