package in.shortlink.shotner;


import in.shortlink.shotner.dto.RegisterDTO;
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
    public ResponseEntity<String> getShortUrl(@RequestBody RegisterDTO body) {
        String shortUrl = this.urlService.getSortUrl(body);
        return ResponseEntity.ok(shortUrl);

    }


    @GetMapping("/{shorturl}")
    public ResponseEntity<Void> getRedirected(@PathVariable String shorturl) {
        String shortUrl = urlService.getRedirected(shorturl);
        System.out.println("=============");
        System.out.println(shortUrl);
        System.out.println("test");
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT).location(URI.create(shortUrl)).build();
    }

}
