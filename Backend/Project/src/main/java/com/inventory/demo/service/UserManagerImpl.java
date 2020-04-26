package com.inventory.demo.service;

import com.inventory.demo.core.model.User;
import com.inventory.demo.core.service.UserManager;
import com.inventory.demo.dao.UserRepository;

import java.util.List;
import java.util.UUID;

public class UserManagerImpl implements UserManager {

    private final UserRepository repo;

    public UserManagerImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<User> listAllUser() {
        return repo.findAll();
    }

    @Override
    public User saveUser(User user) {
        return repo.save(user);
    }

    @Override
    public User getUser(UUID id) {
        return repo.findById(id).get();
    }


    @Override
    public void deleteUser(UUID id) {
        repo.deleteById(id);
    }
}
