package com.inventory.demo.core.service;

import com.inventory.demo.Exception.ProductException;
import com.inventory.demo.core.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductManager {

    public List<Product> listAllProducts() throws ProductException;
    public Product saveProduct(Product products);
    public Product getProduct(UUID id) throws ProductException;
    public void deleteProduct(UUID id) throws ProductException;





}
