package coursereview.springchess.service;

import coursereview.springchess.domain.ChessGame;
import coursereview.springchess.domain.player.BlackPlayer;
import coursereview.springchess.domain.player.WhitePlayer;
import coursereview.springchess.dto.ChessGameResponse;
import org.springframework.stereotype.Service;

@Service
public class ChessService {

    private ChessGame chessGame;

    public ChessGameResponse initBoard() {
        this.chessGame = new ChessGame(new WhitePlayer(), new BlackPlayer(), true);
        return ChessAssembler.toGameResponse(chessGame);
    }
}
