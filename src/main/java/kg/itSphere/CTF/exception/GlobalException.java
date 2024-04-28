package kg.itSphere.CTF.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        ApiResponse apiResponse = new ApiResponse(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(apiResponse, ex.getStatus());
    }
}
