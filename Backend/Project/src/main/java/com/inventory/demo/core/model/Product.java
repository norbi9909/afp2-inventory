package com.inventory.demo.core.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Product {

    @Id
    @GeneratedValue
    UUID productID;
    String productName;
    String productDescription;
    int productCount;
    int productPrice;
    boolean productIsAvailable;

    public Product()
    {
    }
    public Product(UUID productID, String productName, String productDescription, int productCount, int productPrice, boolean productIsAvailable) {
        this.productID = UUID.randomUUID();
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCount = productCount;
        this.productPrice = productPrice;
        this.productIsAvailable = productIsAvailable;
    }

    public UUID getProductID() {
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
