package com.inventory.demo.controller;

import com.inventory.demo.core.model.User;
import com.inventory.demo.core.service.UserManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    private final UserManager manager;

    public static boolean isLoggedIn = false;
    public static int loggedInUserRole  = -1;

    public LoginController(UserManager manager) {
        this.manager = manager;
    }

    @RequestMapping(value = "/login/{id}/{password}")
    public String Login(@PathVariable(name = "id") UUID id, @PathVariable(name = "password") String password){
        User user = manager.getUser(id);
        if(user.getPassword().equals(password)){
            isLoggedIn = true;
            loggedInUserRole = user.getUserRole();
            return "Successfull login";
        }
        return "Unsuccessfull login";
    }

    @RequestMapping(value = "/logout")
    public String Logout(){
        isLoggedIn = false;
        loggedInUserRole = -1;
        return "Successfull logout.";
    }
}
