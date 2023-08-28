package in.shortlink.error;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorPOJO {
    private HttpStatusCode statusCode;
    private String message;
    private LocalDateTime timestamp;
}
