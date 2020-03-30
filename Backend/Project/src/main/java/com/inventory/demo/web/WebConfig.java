package com.inventory.demo.web;

import com.inventory.demo.core.service.ProductManager;
import com.inventory.demo.core.service.UserManager;
import com.inventory.demo.dao.ProductRepository;
import com.inventory.demo.dao.UserRepository;
import com.inventory.demo.service.ProductManagerImplementation;
import com.inventory.demo.service.UserManagerImpl;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class WebConfig {

    @Bean
    public ProductManager productManager(ProductRepository repository){
        return new ProductManagerImplementation(repository);
    }
    @Bean
    public UserManager userManager(UserRepository repository){
        return new UserManagerImpl(repository);
    }
}
