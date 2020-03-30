package com.inventory.demo.core.service;

import com.inventory.demo.core.model.Product;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public interface UserManager {

    public List<User> listAllUser();
    public User saveUser(User user);
    public User getUser(UUID id);
    public void deleteUser(UUID id);

}
