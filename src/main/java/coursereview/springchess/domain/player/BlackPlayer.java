package coursereview.springchess.domain.player;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.chesspiece.Rook;
import coursereview.springchess.domain.position.ChessPosition;

import java.util.Map;

public class BlackPlayer extends ChessPlayer {

    public BlackPlayer() {
        pieces.put(ChessPosition.A8, new Rook());
//        pieces.put(ChessPosition.B8, new Knight());
//        pieces.put(ChessPosition.C8, new Bishop());
//        pieces.put(ChessPosition.D8, new Queen());
//        pieces.put(ChessPosition.E8, new King());
//        pieces.put(ChessPosition.F8, new Bishop());
//        pieces.put(ChessPosition.G8, new Knight());
        pieces.put(ChessPosition.H8, new Rook());

        for (char i = 'A'; i <= 'H'; i++) {
//            String position = String.valueOf(i) + 7;
//            pieces.put(ChessPosition.find(position), new BlackPawn());
        }
    }

    public BlackPlayer(final Map<ChessPosition, ChessPiece> pieces) {
        super(pieces);
    }
}
