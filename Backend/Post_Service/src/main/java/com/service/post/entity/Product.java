package com.service.post.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "product")
public class Product {

    @Id
    private String productId;
    private String productName;
    private String status;
    private String brand;
    private Specification specification;
    private ProductImages productImages;
    private List<String> keyWords;
    private Category category;
}
