package coursereview.springchess.controller;

import coursereview.springchess.controller.dto.MoveRequestDto;
import coursereview.springchess.service.ChessGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessGameController {

    private ChessGameService chessGameService;

    @Autowired
    public ChessGameController(final ChessGameService chessGameService) {
        this.chessGameService = chessGameService;
    }

    @GetMapping("/api/initialized-board")
    public ResponseEntity initializeBoard() {
        return ResponseEntity.ok(chessGameService.initialize());
    }

    @GetMapping("/api/movable-positions/")
    public ResponseEntity getMovablePositions() {
        return ResponseEntity.ok(chessGameService.calculateMovablePositions());
    }

    @PostMapping("/api/move")
    public ResponseEntity move(@RequestBody MoveRequestDto moveRequestDto) {
        return ResponseEntity.ok(chessGameService.move(moveRequestDto.getFrom(), moveRequestDto.getTo()));
    }
}
