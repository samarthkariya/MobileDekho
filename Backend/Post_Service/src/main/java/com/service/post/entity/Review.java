package com.service.post.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("review")
public class Review {
    @Id
    private String reviewId;
    private String reviewContent;
    private int reviewCount;
}
