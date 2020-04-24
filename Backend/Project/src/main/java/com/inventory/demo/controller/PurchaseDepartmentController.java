package com.inventory.demo.controller;

import com.inventory.demo.Exception.ProductException;
import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import org.springframework.web.bind.annotation.*;

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
	
	@RequestMapping(value = "/save",method=RequestMethod.POST)
    public void insertProduct(@RequestBody Product product){
        Product p = new Product();
        p.setProductName(product.getProductName());
        p.setProductDescription(product.getProductDescription());
        p.setProductCount(product.getProductCount());
        p.setProductPrice(product.getProductPrice());
        p.setProductIsAvailable(product.isProductIsAvailable());
        manager.saveProduct(p);
	}

    @RequestMapping(value = "/set",method = RequestMethod.PUT)
    public void updateProduct(@RequestBody Product product) throws ProductException{

        try{
            manager.getProduct(product.getProductID());
        }catch (ProductException e){
            throw new ProductException("No object found with this ID");
        }

        manager.saveProduct(product);
    }

}
