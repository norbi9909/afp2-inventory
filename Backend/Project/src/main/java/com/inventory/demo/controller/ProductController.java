package com.inventory.demo.controller;
import com.inventory.demo.Exception.ProductException;
import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductManager manager;

    public ProductController(ProductManager manager) {
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
    @RequestMapping(value = "/save",method = RequestMethod.POST)
        public void recordProduct(@RequestBody Product product) {

        System.out.println(product);
        manager.saveProduct(product);
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
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductsForm(@PathVariable(name = "id") UUID id) throws ProductException {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = manager.getProduct(id);
        mav.addObject("products",product);
        return mav;
    }
    @RequestMapping("/set")
    public String showNewProductsForm(Model model)
    {
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }
}
