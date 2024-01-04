package com.service.post.controller;

import com.service.post.Util.APIResponse;
import com.service.post.Util.ResponsePage;
import com.service.post.entity.DTO.ProductDTO;
import com.service.post.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO), HttpStatus.CREATED);
    }
    @GetMapping("/lists")
    public ResponsePage<ProductDTO> getProducts(@PageableDefault(sort = "",direction = Sort.Direction.DESC)Pageable pageable){
        return productService.getAllProduct(pageable);
    }

    @DeleteMapping("/delete/{productId}")
    public APIResponse deleteProduct(@PathVariable String productId){
        productService.deleteProduct(productId);
        return new APIResponse("Product is Deleted Successfully",true);
    }
}
