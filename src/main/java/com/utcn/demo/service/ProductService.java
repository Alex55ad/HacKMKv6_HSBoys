package com.utcn.demo.service;

import com.utcn.demo.entity.Order;
import com.utcn.demo.entity.OrderProduct;
import com.utcn.demo.entity.Product;
import com.utcn.demo.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductReviewService productReviewService;

    public List<Product> retrieveProducts() {
        return(List<Product>) this.productRepository.findAll();
    }

    public Product insertProduct(Product product) {
        return this.productRepository.save(product);
    }

    public void deleteProductById(int id) {
        if(this.productRepository.findById(id).isEmpty())
            throw new RuntimeException("User not found");
        else
            this.productRepository.deleteById(id);
    }

    public void updateProductScore(int productId) {
        // Calculate average score for the product
        double averageScore = productReviewService.calculateAverageScoreForProduct(productId);

        // Retrieve the product by productId
        Optional<Product> optionalProduct = productRepository.findById(productId);

        // Update the product score if it exists
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            product.setScore(BigDecimal.valueOf(averageScore));
            productRepository.save(product);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

}
