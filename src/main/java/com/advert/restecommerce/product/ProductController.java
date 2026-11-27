package com.advert.restecommerce.product;

import com.advert.restecommerce.product.dto.ProductRequest;
import com.advert.restecommerce.product.dto.ProductResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse create(@Valid @RequestBody ProductRequest productRequest) {
        return productService.create(productRequest);
    }

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productService.getAllProducts();
    }
    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody ProductRequest productRequest) {
        return productService.update(id, productRequest);
    }

    @PatchMapping("/{id}/publish")
    public ProductResponse publish(@PathVariable Long id) {
        return productService.publish(id);
    }

    @PatchMapping("/{id}/unpublish")
    public ProductResponse unpublish(@PathVariable Long id) {
        return productService.unpublish(id);
    }

}
