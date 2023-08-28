package in.shortlink.shotner.service;

import in.shortlink.shotner.dto.RegisterDTO;

public interface IShortUrlService {
    String getSortUrl(RegisterDTO body);

    String getRedirected(String url);
}
