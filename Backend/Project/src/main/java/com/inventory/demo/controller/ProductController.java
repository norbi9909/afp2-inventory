package com.inventory.demo.controller;
import com.inventory.demo.core.model.Product;
import com.inventory.demo.core.service.ProductManager;
import org.apache.catalina.Manager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductManager manager;

    public ProductController(ProductManager manager) {
        this.manager = manager;
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Product> listAllProduct()
    {
        return manager.listAllProducts();
    }
    @RequestMapping(value = "/save",method = RequestMethod.POST)
        public void recordAuthor(@RequestBody Product product) {
        System.out.println(product);
        manager.saveProduct(product);
    }
    @RequestMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") UUID id)
    {
        manager.deleteProduct(id);
        return "You are delete product by id:" + id;

    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductsForm(@PathVariable(name = "id") UUID id)
    {
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
