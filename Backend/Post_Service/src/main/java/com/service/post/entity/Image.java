package com.service.post.entity;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "image")
public class Image {
    @Id
    private String imageId;
    private String imageName;
    private Binary image;
}
