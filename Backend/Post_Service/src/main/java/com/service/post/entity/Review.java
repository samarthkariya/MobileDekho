package com.service.post.entity;

import lombok.Data;

@Data
public class Review {
    private String userId;
    private String reviewContent;
    private int reviewCount;
}
