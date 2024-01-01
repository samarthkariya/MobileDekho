package com.service.post.entity.DTO;

import com.service.post.entity.Category;
import com.service.post.entity.ProductImages;
import com.service.post.entity.Specification;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {
    private String productId;
    private String productName;
    private String brand;
    private String status;
    private Specification specification;
    private List<ProductImages> productImages = new ArrayList<>();
    private List<String> keyWords;
    private Category category;
}
