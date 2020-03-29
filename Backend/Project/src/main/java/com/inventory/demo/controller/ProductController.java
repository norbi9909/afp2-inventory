package com.inventory.demo.controller;
import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductManager manager;

    public ProductController(ProductManager manager) {
        this.manager = manager;
    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Collection<Product> listAllProduct()
    {
        return manager.listAllProducts();
    }
    @RequestMapping(value = "/Worker/List",method = RequestMethod.POST)
        public void recordAuthor(@RequestBody Product product){
        System.out.println(product);
        manager.saveProduct(product);

    }
}
