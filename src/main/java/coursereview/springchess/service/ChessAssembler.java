package coursereview.springchess.service;

import coursereview.springchess.domain.ChessGame;
import coursereview.springchess.domain.chesspiece.ChessPiece;
import coursereview.springchess.domain.player.ChessPlayer;
import coursereview.springchess.domain.position.ChessPosition;
import coursereview.springchess.domain.position.ChessPositions;
import coursereview.springchess.domain.position.MovablePositions;
import coursereview.springchess.dto.ChessGameResponse;
import coursereview.springchess.dto.ChessMovablePositionsResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        double scoreWhite = chessGame.getScoreOfWhitePlayer();
        double scoreBlack = chessGame.getScoreOfBlackPlayer();

        String gameStatus = chessGame.isGameGoingOn() ? "battle" : "end";

        return new ChessGameResponse(positionsOfPieces, turn, scoreWhite, scoreBlack, gameStatus);
    }

    private static void registerPositions(final Map<String, String> positionsOfPieces, final Map<ChessPosition, ChessPiece> whitePieces, final String signOfTeam) {
        for (Map.Entry<ChessPosition, ChessPiece> entry : whitePieces.entrySet()) {
            ChessPosition key = entry.getKey();
            ChessPiece value = entry.getValue();

            positionsOfPieces.put(key.getPosition(), signOfTeam + value.getSign());
        }
    }

    public static ChessMovablePositionsResponse toMovablePositionResponse(final MovablePositions movablePositions) {
        Map<String, List<String>> response = new HashMap<>();

        Map<ChessPosition, ChessPositions> positions = movablePositions.getPositions();
        positions.forEach((key, value) -> response.put(key.getPosition()
                , value.getPositions().stream()
                        .map(ChessPosition::getPosition)
                        .collect(Collectors.toList())
        ));
        return new ChessMovablePositionsResponse(response);
    }
}
