package com.inventory.demo.controller;

import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/sales")
public class SalesTeamController {
    private final ProductManager manager;

    public SalesTeamController(ProductManager manager) {
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

    @RequestMapping(value = "/set",method = RequestMethod.PUT)
    public void updateProduct(@RequestBody Product product) throws Exception{
        Product p;

        try{
            p = manager.getProduct(product.getProductID());
        }catch (Exception e){
            throw new Exception("No object found with this ID");
        }

        if(!p.getProductName().equals(product.getProductName()) || p.getProductPrice() != product.getProductPrice() || p.getProductCount() != product.getProductCount()){
            throw new Exception("You can only change the product description!");
        }

        manager.saveProduct(product);
    }
}
