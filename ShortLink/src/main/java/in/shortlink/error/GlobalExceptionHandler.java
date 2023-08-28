package in.shortlink.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoUrlFound.class)
    public ResponseEntity<ErrorPOJO> invalidShortUrl(NoUrlFound e) {

        ErrorPOJO error = new ErrorPOJO();
        error.setMessage(e.getMessage());
        error.setStatusCode(e.statusCode);
        error.setTimestamp(LocalDateTime.now());

        return ResponseEntity.status(e.statusCode).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorPOJO> allException(Exception e) {

        ErrorPOJO error = new ErrorPOJO();
        error.setMessage(e.getMessage());
        error.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        error.setTimestamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
