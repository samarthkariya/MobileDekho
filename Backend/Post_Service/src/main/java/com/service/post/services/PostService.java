package com.service.post.services;

import com.service.post.entity.DTO.PostDTO;
import com.service.post.entity.Post;
import com.service.post.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PostService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PostRepository postRepo;

    public PostDTO createPost(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        post.setCreatedAt(Instant.now());
        return modelMapper.map(postRepo.save(post), PostDTO.class);
    }
}
