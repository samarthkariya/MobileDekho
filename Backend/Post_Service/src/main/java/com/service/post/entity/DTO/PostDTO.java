package com.service.post.entity.DTO;

import com.service.post.entity.Product;
import com.service.post.entity.Review;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class PostDTO {
    private String postId;
    private String title;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private String postStatus;
    private String postType;
    private String userId;
    private List<String> keyWords;
    private Product product;
    private List<Review> review = new ArrayList<>();
}
