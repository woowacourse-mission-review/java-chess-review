package coursereview.springchess.controller;

import coursereview.springchess.dto.ChessGameResponse;
import coursereview.springchess.service.ChessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessController {

    private final ChessService chessService;

    public ChessController(final ChessService chessService) {
        this.chessService = chessService;
    }

    @GetMapping("/api/initialized-board")
    public ResponseEntity<ChessGameResponse> fetchInitializedBoard() {
        ChessGameResponse chessGameResponse = chessService.initBoard();
        return new ResponseEntity<>(chessGameResponse, HttpStatus.OK);
    }
}
