package com.service.post.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("product")

public class Product {

    @Id
    private String productId;
    private String productType;
    private Specification specification;
    private ProductImages images;

}
