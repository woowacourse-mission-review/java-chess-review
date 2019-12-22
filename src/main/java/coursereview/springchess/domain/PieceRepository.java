package coursereview.springchess.domain;

import coursereview.springchess.domain.piece.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PieceRepository extends JpaRepository<Piece, Long> {

    List<Piece> findAllByGameId(Long currentGameId);
}
