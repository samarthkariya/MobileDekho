package com.service.post.services;

import com.service.post.Util.ResponsePage;
import com.service.post.entity.DTO.ProductDTO;
import com.service.post.entity.Product;
import com.service.post.exception.ResourceNotFoundException;
import com.service.post.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepository productRepo;

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);
        return modelMapper.map(productRepo.save(product), ProductDTO.class);
    }
    public ResponsePage<ProductDTO> getAllProduct(Pageable pageable){
         Page<Product> products = productRepo.findAll(pageable);
        List<Product> productList = products.getContent();
        List<ProductDTO> productDTOList = productList.stream().map((product)->modelMapper.map(product,ProductDTO.class)).collect(Collectors.toList());
        return new ResponsePage<>(productDTOList, products.getNumber(), productList.size(), products.getTotalPages(), products.getTotalElements());
    }

    public void deleteProduct(String productId){
        Product product = productRepo.findById(productId).orElseThrow(()-> new ResourceNotFoundException("Product", "Id", productId));
        productRepo.delete(product);
    }
}
