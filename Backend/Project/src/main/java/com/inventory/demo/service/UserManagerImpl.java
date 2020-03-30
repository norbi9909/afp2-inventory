package com.inventory.demo.service;

import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import com.inventory.demo.dao.ProductRepository;

import java.util.List;
import java.util.UUID;

public class UserManagerImpl implements UserManager {

    private final UserRepository repo;

    public UserManagerImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> listAllProducts() {
        return repo.findAll();
    }

    @Override
    public User saveProduct(Product products) {
        return repo.save(products);
    }

    @Override
    public User getProduct(UUID id) {
        return repo.findById(id).get();
    }

    @Override
    public void deleteProduct(UUID id) {
        repo.deleteById(id);
    }
}
