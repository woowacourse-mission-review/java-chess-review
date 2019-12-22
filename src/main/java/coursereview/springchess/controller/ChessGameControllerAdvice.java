package coursereview.springchess.controller;

import coursereview.springchess.controller.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ChessGameControllerAdvice {

    private static final Logger log = LoggerFactory.getLogger(ChessGameControllerAdvice.class);

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity handleError(Exception exception) {
        log.error("Exception Occurs : {}", exception.getMessage());
        return ResponseEntity.status(406)
                .body(new MessageDto(exception.getMessage()));
    }
}
