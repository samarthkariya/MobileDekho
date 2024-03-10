package com.service.post.services;

import com.service.post.entity.Image;
import com.service.post.exception.ResourceNotFoundException;
import com.service.post.repositories.ImageRepository;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    public Image addImage(String name, MultipartFile file)throws IOException{
        Image image=new Image();
        image.setImageName(name);
        image.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        return imageRepository.save(image);

    }

    public List<Image> getAllImage(List<String> imageIds){
        return imageRepository.findAllById(imageIds);
    }

    public Image getImage(String imageId){
        return imageRepository.findById(imageId).orElseThrow(()->new ResourceNotFoundException("Image","ImageId",imageId));
    }
}
