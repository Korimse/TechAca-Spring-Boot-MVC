package first.project.api.util;

import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class Message {
    private String message;
    private int status;
    private String code;
}
