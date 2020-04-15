package com.inventory.demo.controller;

import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/purchasedepartment")
public class PurchaseDepartmentController {
    private final ProductManager manager;

    public PurchaseDepartmentController(ProductManager manager) {
        this.manager = manager;
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Collection<Product> listAllProduct()
    {
        return manager.listAllProducts();
    }
    @RequestMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") UUID id)
    {
        manager.deleteProduct(id);
        return "You are delete product by id:" + id;

    }

}
