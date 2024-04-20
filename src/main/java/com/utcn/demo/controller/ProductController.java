package com.utcn.demo.controller;

import com.utcn.demo.entity.Product;
import com.utcn.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<Product> retrieveAllProducts(){
        return productService.retrieveProducts();
    }

    @PostMapping("/insert")
    public Product insertProduct(@RequestBody Product product){
        return productService.insertProduct(product);
    }

    @DeleteMapping("/delete")
    public void deleteProductById(@RequestParam int id){
        productService.deleteProductById(id);
    }

    @PutMapping("/updateScore")
    public void updateProductScore(@RequestParam int productId) {
        productService.updateProductScore(productId);
    }
}
