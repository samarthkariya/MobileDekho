package com.service.post.services;

import com.service.post.Util.ResponsePage;
import com.service.post.entity.DTO.ProductDTO;
import com.service.post.entity.Image;
import com.service.post.entity.Product;
import com.service.post.entity.ProductImages;
import com.service.post.exception.ResourceNotFoundException;
import com.service.post.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private ImageService imageService;

    public ProductDTO createProduct(ProductDTO productDTO, MultipartFile thumbnail, List<MultipartFile> imageList) throws IOException {
        Image thumbID = imageService.addImage(thumbnail.getOriginalFilename(), thumbnail);
        List<Image> images = new ArrayList<>();
        for (MultipartFile file : imageList) {
            images.add(imageService.addImage(file.getOriginalFilename(), file));
        }
        productDTO.setProductImages(new ProductImages(thumbID, images));
        Product product = modelMapper.map(productDTO, Product.class);
        return modelMapper.map(productRepo.save(product), ProductDTO.class);
    }
    public ProductDTO getProductById(String productId){
        return modelMapper.map(productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId)),ProductDTO.class);
    }
    public ResponsePage<ProductDTO> getAllProduct(Pageable pageable) {
        Page<Product> products = productRepo.findAll(pageable);
        List<Product> productList = products.getContent().stream().toList();
        List<ProductDTO> productDTOList = productList.stream().map((product) -> modelMapper.map(product, ProductDTO.class)).collect(Collectors.toList());
        return new ResponsePage<>(productDTOList, products.getNumber(), productList.size(), products.getTotalPages(), products.getTotalElements());
    }

    public void deleteProduct(String productId) {
        Product product = productRepo.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", productId));
        productRepo.delete(product);
    }
}
