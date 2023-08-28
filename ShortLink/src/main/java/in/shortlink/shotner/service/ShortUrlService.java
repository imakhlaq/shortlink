package in.shortlink.shotner.service;

import in.shortlink.error.NoUrlFound;
import in.shortlink.shotner.dto.RegisterDTO;
import in.shortlink.shotner.model.ShortUrlRepository;
import in.shortlink.shotner.model.UrlModel;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class ShortUrlService implements IShortUrlService {

    ShortUrlRepository repo;

    @Autowired
    ShortUrlService(ShortUrlRepository repo) {
        this.repo = repo;
    }


    @Override
    public String getSortUrl(RegisterDTO body) {

        String uniqueUrl = RandomStringUtils.random(10, true, true);

        System.out.println(uniqueUrl);
        UrlModel urlModel = new UrlModel();
        urlModel.setOriginalUrl(body.getUrl());
        urlModel.setSortUrl(uniqueUrl);
        urlModel.setOwnerName(body.getOwner());

        return repo.save(urlModel).getSortUrl();
    }

    @Override
    public String getRedirected(String shortUrl) {
        return repo.findBySortUrlIs(shortUrl).orElseThrow(() -> new NoUrlFound(HttpStatus.NOT_FOUND, "No Url Found")).getOriginalUrl();
    }
}
