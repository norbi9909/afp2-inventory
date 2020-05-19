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
    @RequestMapping(value = "/save",method = RequestMethod.POST)
        public void recordProduct(@RequestBody Product product) throws Exception {
        if(LoginController.loggedInUserRole == 1){
            System.out.println(product);
            manager.saveProduct(product);
        } else{
            throw new ProductException("You don't have access to this method!");
        }

    }
    @GetMapping(value = "/list/{id}")
    public Product getProductByID(@PathVariable(name = "id") UUID id) throws ProductException {
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

    @RequestMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") UUID id) throws Exception {
        if(LoginController.loggedInUserRole == 1) {
            try {
                manager.deleteProduct(id);
            } catch (Exception e) {
                throw new ProductException("There is no existing product with id: " + id);
            }
            return "You have successfully deleted a product by id:" + id;
        }else{
            throw new ProductException( "You don't have access to this method!");
        }
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductsForm(@PathVariable(name = "id") UUID id) throws Exception {
        if(LoginController.loggedInUserRole == 1){
            ModelAndView mav = new ModelAndView("edit_product");
            Product product = manager.getProduct(id);
            mav.addObject("products",product);
            return mav;
        }else{
            throw new ProductException("You don't have access to this method!");
        }

    }
    @RequestMapping("/set")
    public String showNewProductsForm(Model model) throws Exception {
        if(LoginController.loggedInUserRole == 1){
            Product product = new Product();
            model.addAttribute("product",product);
            return "new_product";
        }else{
            System.out.println("You don't have access to this method!");
            throw new ProductException("You don't have access to this method!");
        }

    }
}
