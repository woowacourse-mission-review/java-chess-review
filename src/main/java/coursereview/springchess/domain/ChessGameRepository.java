package coursereview.springchess.domain;

import coursereview.springchess.domain.game.ChessGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChessGameRepository extends JpaRepository<ChessGame, Long> {
}
