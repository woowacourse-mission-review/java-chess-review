package coursereview.springchess.controller.dto;

import lombok.Getter;

@Getter
public class MessageDto {

    private String message;

    public MessageDto(final String message) {
        this.message = message;
    }
}
