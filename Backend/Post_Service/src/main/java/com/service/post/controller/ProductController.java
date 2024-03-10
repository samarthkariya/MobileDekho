package com.service.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.post.Util.APIResponse;
import com.service.post.Util.ResponsePage;
import com.service.post.entity.DTO.ProductDTO;
import com.service.post.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ObjectMapper mapper;

    @PostMapping("/add")
    public ResponseEntity<ProductDTO> createProduct(@RequestParam("productDto") String productDto,
                                                    @RequestParam("thumbnail") MultipartFile thumbnail,
                                                    @RequestParam("imageList") List<MultipartFile> imageList) throws IOException {
        ProductDTO productDTO = mapper.readValue(productDto, ProductDTO.class);
        return new ResponseEntity<>(productService.createProduct(productDTO, thumbnail, imageList), HttpStatus.CREATED);
    }
    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@RequestParam String productId){
        return new ResponseEntity<>(productService.getProductById(productId),HttpStatus.OK);
    }
    @GetMapping(value = "/lists", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePage<ProductDTO> getProducts(@PageableDefault(sort = "", direction = Sort.Direction.DESC) Pageable pageable) {
        return productService.getAllProduct(pageable);
    }

    @DeleteMapping("/delete/{productId}")
    public APIResponse deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return new APIResponse("Product is Deleted Successfully", true);
    }
}
