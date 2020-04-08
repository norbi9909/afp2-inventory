package com.inventory.demo.controller;

import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
@RestController
@RequestMapping(value = "/Worker")
public class WorkerController {
    private final ProductManager manager;

    public WorkerController(ProductManager manager) {
        this.manager = manager;
    }
    @RequestMapping(value = "/Worker/List",method = RequestMethod.GET)
    public Collection<Product> listAllProduct()
    {
        return manager.listAllProducts();
    }
}
