package coursereview.springchess.service;

import coursereview.springchess.domain.ChessGame;
import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.player.BlackPlayer;
import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.player.WhitePlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.dto.ChessGameResponse;

import java.util.HashMap;
import java.util.Map;

public class ChessAssembler {

    private ChessAssembler() {
    }

    public static ChessGameResponse toGameResponse(ChessGame chessGame) {
        final ChessPlayer whitePlayer = chessGame.getWhitePlayer();
        final ChessPlayer blackPlayer = chessGame.getBlackPlayer();
        Map<ChessPosition, ChessPiece> whitePieces = whitePlayer.getPieces();
        Map<ChessPosition, ChessPiece> blackPieces = blackPlayer.getPieces();

        Map<String, String> positionsOfPieces = new HashMap<>();
        registerPositions(positionsOfPieces, whitePieces, "w");
        registerPositions(positionsOfPieces, blackPieces, "b");

        String turn = chessGame.isWhiteTurn() ? "white" : "black";

        return new ChessGameResponse(positionsOfPieces, turn, 10, 15, "battle");
    }

    private static void registerPositions(final Map<String, String> positionsOfPieces, final Map<ChessPosition, ChessPiece> whitePieces, final String signOfTeam) {
        for (Map.Entry<ChessPosition, ChessPiece> entry : whitePieces.entrySet()) {
            ChessPosition key = entry.getKey();
            ChessPiece value = entry.getValue();

            positionsOfPieces.put(key.getPosition(), signOfTeam + value.getSign());
        }
    }
}
