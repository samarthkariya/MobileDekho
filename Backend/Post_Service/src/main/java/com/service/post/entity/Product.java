package com.service.post.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "product")
public class Product {

    @Id
    private String productId;
    private String productName;
    private String status;
    private String brand;
    private Specification specification;
    private List<ProductImages> productImages = new ArrayList<>();
    private List<String> keyWords;
    private Category category;
}
