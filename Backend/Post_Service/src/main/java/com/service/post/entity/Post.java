package com.service.post.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "post")
public class Post {

    @Id
    private String postId;
    private String title;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private String postStatus; // any upcomming product
    private String postType; // there is only 2 type active and draft
    private String userId;
    private List<String> keyWords;
    private List<Review> review = new ArrayList<>();
    @DBRef
    private Product product;


}
