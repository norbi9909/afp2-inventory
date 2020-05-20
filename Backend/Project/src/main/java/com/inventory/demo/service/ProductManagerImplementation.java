package com.inventory.demo.service;

import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import com.inventory.demo.dao.ProductRepository;

import java.util.List;
import java.util.UUID;

public class ProductManagerImplementation implements ProductManager {

    private final ProductRepository repo;

    public ProductManagerImplementation(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> listAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product saveProduct(Product products) {
        return repo.save(products);
    }

    @Override
    public Product getProduct(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteProduct(Long id) {
        repo.deleteById(id);
    }
}
