package com.service.post.entity;

import org.springframework.data.annotation.Id;

import java.util.List;

public class ProductImages {
    @Id
    private String imageId;
    private ColorCode colorCode;
    private List<String> images;

}
