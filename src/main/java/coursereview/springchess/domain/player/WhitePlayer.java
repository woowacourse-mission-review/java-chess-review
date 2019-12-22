package coursereview.springchess.domain.player;

import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.chesspiece.Rook;
import coursereview.springchess.domain.position.ChessPosition;

import java.util.Map;

public class WhitePlayer extends ChessPlayer {

    public WhitePlayer() {
        pieces.put(ChessPosition.A1, new Rook());
//        pieces.put(ChessPosition.B1, new Knight());
//        pieces.put(ChessPosition.C1, new Bishop());
//        pieces.put(ChessPosition.D1, new Queen());
//        pieces.put(ChessPosition.E1, new King());
//        pieces.put(ChessPosition.F1, new Bishop());
//        pieces.put(ChessPosition.G1, new Knight());
        pieces.put(ChessPosition.H1, new Rook());

        for (char i = 'A'; i <= 'H'; i++) {
//            String position = String.valueOf(i) + 2;
//            pieces.put(ChessPosition.find(position), new WhitePawn());
        }
    }

    public WhitePlayer(final Map<ChessPosition, ChessPiece> pieces) {
        super(pieces);
    }
}
