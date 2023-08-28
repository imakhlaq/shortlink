package in.shortlink.shotner.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlModel {
    @Id
    private String id;

    @CreatedBy
    private String ownerName;

    private String originalUrl;
    @Indexed(unique = true)
    private String sortUrl;

    @LastModifiedDate
    private LocalDateTime updatedAt;
    @CreatedDate
    private LocalDateTime createdAt;
}
