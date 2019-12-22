package coursereview.springchess.domain.piece;

import coursereview.springchess.domain.common.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
@Entity
@Table(name = "piece")
@Getter
@ToString
public class Piece {

    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    @Id
    private Long id;

    @Column(name = "gameId", nullable = false)
    private Long gameId;

    @Embedded
    private PieceInfo pieceInfo;

    @Embedded
    private Position position;

    public Piece(final Long gameId, final PieceInfo pieceInfo, final Position position) {
        this.gameId = gameId;
        this.pieceInfo = pieceInfo;
        this.position = position;
    }

    public RowPosition getRow() {
        return position.getRow();
    }

    public ColumnPosition getColumn() {
        return position.getColumn();
    }

    public Type getType() {
        return pieceInfo.getType();
    }

    public Color getColor() {
        return pieceInfo.getColor();
    }
}
