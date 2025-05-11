package com.simpleapp.productcrud.service;

import org.springframework.stereotype.Service;

import com.simpleapp.productcrud.model.Product;
import com.simpleapp.productcrud.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product newProduct) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    product.setDescription(newProduct.getDescription());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
