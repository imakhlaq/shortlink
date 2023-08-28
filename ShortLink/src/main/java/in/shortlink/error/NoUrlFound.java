package in.shortlink.error;


import org.springframework.http.HttpStatusCode;

public class NoUrlFound extends RuntimeException {

    HttpStatusCode statusCode;

    public NoUrlFound(HttpStatusCode code, String message) {
        super(message);
        this.statusCode = code;
    }

}
