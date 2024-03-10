package com.service.post.entity.DTO;

import com.service.post.entity.Category;
import com.service.post.entity.ProductImages;
import com.service.post.entity.Specification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private String productId;
    private String productName;
    private String brand;
    private String status;
    private Specification specification;
    private ProductImages productImages;
    private List<String> keyWords;
    private Category category;
}
