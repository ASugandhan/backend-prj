package com.examly.springapp.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column
    private String productName;

    @Column(nullable= true)
    private double price;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public Product(){}

    public Product(Long productId, String productName, double price){
        this.productId=productId;
        this.productName=productName;
        this.price=price;
    }

    public Long getProductId(){
        return productId;
    }
    public void setProductId(Long productId){
        this.productId=productId;
    }

    public String getProductName(){
        return productName;
    }

    public void setProductName(String productName){
        this.productName=productName;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price=price;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category category){
        this.category=category;
    }

}
