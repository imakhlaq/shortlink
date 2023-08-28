package in.shortlink.shotner.model;

import in.shortlink.shotner.model.UrlModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ShortUrlRepository extends MongoRepository<UrlModel, String> {
    Optional<UrlModel> findBySortUrlIs(String shortUrl);
}
