package com.service.post.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImages {
    @DBRef
    private Image thumbnail;
    @DBRef
    private List<Image> imageList;
}
