package com.advert.restecommerce.product;

import com.advert.restecommerce.common.exception.ResourceNotFoundException;
import com.advert.restecommerce.product.dto.ProductRequest;
import com.advert.restecommerce.product.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    public ProductResponse getById(Long id){
        Product product = findProductOrThrow(id);
        return productMapper.toProductResponse(product);
    }

    @Transactional
    public ProductResponse create(ProductRequest productRequest){
        Product product = productMapper.toProductEntity(productRequest);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAllProducts(){
        return productRepository.findByActiveTrue()
                .stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest productRequest){
        Product product = findProductOrThrow(id);
        productMapper.updateEntity(productRequest,product);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    // helper methods
    private Product findProductOrThrow(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " id Product not found"));
    }
}

