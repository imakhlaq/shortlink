package in.shortlink.shotner;


import in.shortlink.shotner.dto.RegisterDTO;
import in.shortlink.shotner.dto.ResponseBody;
import in.shortlink.shotner.service.IShortUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class ShortUrlController {

    IShortUrlService urlService;

    @Autowired
    ShortUrlController(IShortUrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("/shorturl")
    public ResponseEntity<ResponseBody> getShortUrl(@RequestBody RegisterDTO body) {
        String shortUrl = this.urlService.getSortUrl(body);
        ResponseBody responseBody = new ResponseBody();
        responseBody.setShortURl("http://127.0.0.1:8080/" + shortUrl);
        responseBody.setStatusCode(HttpStatus.OK);
        return ResponseEntity.ok(responseBody);

    }


    @GetMapping("/{shorturl}")
    public ResponseEntity<Void> getRedirected(@PathVariable String shorturl) {
        String url = urlService.getRedirected(shorturl);
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(URI.create(url)).build();
    }

}
