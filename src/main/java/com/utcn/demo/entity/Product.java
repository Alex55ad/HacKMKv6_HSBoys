package com.utcn.demo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name ="Products")
public class Product {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProductList;

    @Column(name="price")
    private BigDecimal price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "description")  // New column for specifications
    private String description;

    public Product() {
    }

    public Product(int id, String name, List<OrderProduct> orderProductList, BigDecimal price, int stock, String description) {
        this.id = id;
        this.name = name;
        this.orderProductList = orderProductList;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProduct> orderProductList) {
        this.orderProductList = orderProductList;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
