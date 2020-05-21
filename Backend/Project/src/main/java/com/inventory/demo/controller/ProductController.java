package com.inventory.demo.controller;
import com.inventory.demo.Exception.ProductException;
import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping(value = "/product")
@CrossOrigin(origins = "http://localhost:3000")
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
    @PostMapping(value = "/save")
    public void insertProduct(@RequestBody Product product){
        manager.saveProduct(product);
    }
    @GetMapping(value = "/list/{id}")
    public Product getProductByID(@PathVariable(name = "id") Long id) throws ProductException {
        try
        {
            manager.getProduct(id);
        }
        catch (Exception e)
        {
            throw new ProductException("There is no existing product with id: " + id);
        }
        return manager.getProduct(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) throws Exception {
                manager.deleteProduct(id);
            return "You have successfully deleted a product by id:" + id;
    }
    @PutMapping(value = "/update/{id}")
    public void updateProduct(@PathVariable(name = "id")Long id)
    {
        manager.updateProduct(id);
    }
}
