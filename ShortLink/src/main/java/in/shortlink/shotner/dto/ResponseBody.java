package in.shortlink.shotner.dto;


import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
public class ResponseBody {
    private HttpStatusCode statusCode;
    private String ShortURl;

}
