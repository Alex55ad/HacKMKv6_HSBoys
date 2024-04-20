package com.utcn.demo.service;

import com.utcn.demo.entity.Product;
import com.utcn.demo.entity.ProductReview;
import com.utcn.demo.repository.ProductRepository;
import com.utcn.demo.repository.ProductReviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
@Transactional
public class ProductReviewService {

    @Autowired
    private ProductReviewRepository productReviewRepository;
    @Autowired
    ProductRepository productRepository;

    public List<ProductReview> retrieveProductReviews() {
        return productReviewRepository.findAll();
    }

    public ProductReview insertProductReview(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    public void deleteProductReviewById(int id) {
        Optional<ProductReview> optionalProductReview = productReviewRepository.findById(id);
        if (optionalProductReview.isEmpty())
            throw new RuntimeException("Product review not found");
        else
            productReviewRepository.deleteById(id);
    }

    public double calculateAverageScoreForProduct(int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            List<ProductReview> productReviews = productReviewRepository.findByProduct(product);
            // Calculate average score
            OptionalDouble averageScore = productReviews.stream()
                    .mapToInt(ProductReview::getRating)
                    .average();

            return averageScore.orElse(0.0);
        }
        else throw new RuntimeException("Product not found");
    }
}