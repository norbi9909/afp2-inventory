package com.inventory.demo.controller;
import com.inventory.demo.Exception.ProductException;
import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.model.User;
import com.inventory.demo.core.service.UserManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserManager manager;

    public UserController(UserManager manager)
    {
        this.manager = manager;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<User> listAllUser()
    {
        return manager.listAllUser();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
        public void recordUser(@RequestBody User user) {
        System.out.println(user);
        manager.saveUser(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") UUID id)
    {
        manager.deleteUser(id);
        return "You are successfully delete user by id:" + id;
    }

    @GetMapping(value = "/list/{id}")
    public User getUserByID(@PathVariable(name = "id") UUID id) throws Exception {
        try
        {
            manager.getUser(id);
        }
        catch (Exception e)
        {
            throw new Exception("Dont exist user with this id: " + id);
        }
        return manager.getUser(id);
    }
}

