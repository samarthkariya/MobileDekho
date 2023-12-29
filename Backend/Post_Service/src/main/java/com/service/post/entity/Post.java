package com.service.post.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Data
@Document("post")
public class Post {

    @Id
    private String postId;
    private String title;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private String postStatus;
    private String postType;
    private String userId;
    private List<String> keyWords;
    private Category category;
    private Product product;
    private Review review;


}
