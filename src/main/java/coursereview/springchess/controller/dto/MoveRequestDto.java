package coursereview.springchess.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MoveRequestDto {

    private String from;
    private String to;
}
