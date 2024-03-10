package com.service.post.services;

import com.service.post.Util.ResponsePage;
import com.service.post.entity.DTO.PostDTO;
import com.service.post.entity.Post;
import com.service.post.exception.ResourceNotFoundException;
import com.service.post.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

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
    public PostDTO getPostById(String postId){
        return modelMapper.map(postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId)),PostDTO.class);
    }
    public ResponsePage<PostDTO> getAllPost(Pageable pageable) {
        Page<Post> postPage = postRepo.findAll(pageable);
        List<Post> postList = postPage.getContent().stream().toList();
        List<PostDTO> postDTOList = postList.stream().map((post) -> modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return new ResponsePage<>(postDTOList, postPage.getNumber(), postPage.getSize(), postPage.getTotalPages(), postPage.getTotalElements());
    }

    public void deletePost(String postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
        postRepo.delete(post);
    }
}
