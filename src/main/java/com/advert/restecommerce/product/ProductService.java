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
    public List<ProductResponse> getActiveProducts(String search){
        List<Product> products;
        if (search == null || search.isBlank()){
            products = productRepository.findByActiveTrue();
        }
        else {
            products = productRepository.findByActiveTrueAndNameContainingIgnoreCase(search);
        }
        return products.stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest productRequest){
        Product product = findProductOrThrow(id);
        productMapper.updateEntity(productRequest,product);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Transactional
    public ProductResponse publish(Long id){
        Product product = findProductOrThrow(id);
        product.publish();
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Transactional
    public ProductResponse unpublish(Long id){
        Product product = findProductOrThrow(id);
        product.unpublish();
        return productMapper.toProductResponse(productRepository.save(product));
    }

    // helper methods
    private Product findProductOrThrow(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " id Product not found"));
    }


}

