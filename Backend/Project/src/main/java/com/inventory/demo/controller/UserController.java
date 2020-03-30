package com.inventory.demo.controller;
import com.inventory.demo.core.model.User;
import com.inventory.demo.core.service.UserManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserManager manager;

    public UserController(UserManager manager) {
        this.manager = manager;
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> listAllUser()
    {
        return manager.listAllUser();
    }
    @RequestMapping(value = "/User/List",method = RequestMethod.POST)
        public void recordUser(@RequestBody User user){
        System.out.println(user);
        manager.saveUser(user);

    }
}
