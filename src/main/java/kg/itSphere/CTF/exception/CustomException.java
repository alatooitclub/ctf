package kg.itSphere.CTF.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public CustomException(String message, HttpStatus status) {
        super(message);
        this.status = status;
        this.message = message;
    }
}
