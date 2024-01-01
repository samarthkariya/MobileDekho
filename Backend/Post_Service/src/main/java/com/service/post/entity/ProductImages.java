package com.service.post.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class ProductImages {
    private String thumbnail;
    private List<String> images;
}
