package com.service.post.controller;

import com.service.post.Util.APIResponse;
import com.service.post.Util.ResponsePage;
import com.service.post.entity.DTO.PostDTO;
import com.service.post.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/add")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }
    @GetMapping("list")
    public ResponsePage<PostDTO> getAllPost(@PageableDefault(sort = "", direction = Sort.Direction.DESC) Pageable pageable){
        return postService.getAllPost(pageable);
    }
    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPostById(@RequestParam String postId){
        return new ResponseEntity<>(postService.getPostById(postId),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{postId}")
    public APIResponse deletePost(@PathVariable String postId) {
        postService.deletePost(postId);
        return new APIResponse("Post is Deleted Successfully", true);
    }
}
