package com.inventory.demo.core.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "productID")
    Long productID;
    @Column(name = "product_Name")
    String productName;
    @Column(name = "product_Description")
    String productDescription;
    @Column(name = "product_Count")
    int productCount;
    @Column(name = "product_Price")
    int productPrice;
    @Column(name = "product_is_Available")
    boolean productIsAvailable;

    public Product()
    {
    }
    public Product(Long productID, String productName, String productDescription, int productCount, int productPrice, boolean productIsAvailable) {
        this.productID = productID;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCount = productCount;
        this.productPrice = productPrice;
        this.productIsAvailable = productIsAvailable;
    }

    public Long getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isProductIsAvailable() {
        return productIsAvailable;
    }

    public void setProductIsAvailable(boolean productIsAvailable) {
        this.productIsAvailable = productIsAvailable;
    }
}
