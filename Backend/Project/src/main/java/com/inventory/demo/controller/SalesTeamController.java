package com.inventory.demo.controller;

import com.inventory.demo.Exception.ProductException;
import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/sales")
@CrossOrigin(origins = "http://localhost:3000")
public class SalesTeamController {
    private final ProductManager manager;

    public SalesTeamController(ProductManager manager) {
        this.manager = manager;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Collection<Product> listAllProduct() throws ProductException
    {
        if (manager.listAllProducts().isEmpty())
        {
            throw new ProductException("No product was found in the database");
        }
        return manager.listAllProducts();
    }

    @GetMapping(value = "/list/{id}")
    public Product getProductByID(@PathVariable(name = "id") UUID id) throws ProductException {
        try
        {
            manager.getProduct(id);
        }
        catch (Exception e)
        {
            throw new ProductException("Dont exist product with this id: " + id);
        }
        return manager.getProduct(id);
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") UUID id) throws ProductException{
        try
        {
            manager.deleteProduct(id);
        }
        catch (Exception e)
        {
            throw new ProductException("Can't delete because dont exist product with this id:" + id);
        }
        return "You are successfully delete product by id:" + id;
    }

    @RequestMapping(value = "/set",method = RequestMethod.PUT)
    public void updateProduct(@RequestBody Product product) throws ProductException{
        Product p;

        try{
            p = manager.getProduct(product.getProductID());
        }catch (Exception e){
            throw new ProductException("No object found with this ID");
        }

        if(!p.getProductName().equals(product.getProductName()) || p.getProductPrice() != product.getProductPrice() || p.getProductCount() != product.getProductCount()){
            throw new ProductException("You can only change the product description!");
        }

        manager.saveProduct(product);
    }
}
