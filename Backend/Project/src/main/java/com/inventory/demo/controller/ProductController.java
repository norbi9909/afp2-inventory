package com.inventory.demo.controller;
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

    @RequestMapping(value = "/product/list",method = RequestMethod.GET)
    public Collection<Product> listAllProduct()
    {
        return manager.listAllProducts();
    }

    @RequestMapping(value = "/product/save",method = RequestMethod.POST)
        public void recordAuthor(@RequestBody Product product) {
        System.out.println(product);
        manager.saveProduct(product);
    }
    @RequestMapping(value = "/product/delete/{id}")
        public String deleteProduct(@PathVariable(name = "id") UUID id)
        {
            manager.deleteProduct(id);
            return "redirect:/";
        }
    @RequestMapping("/product/edit/{id}")
    public ModelAndView showEditProductsForm(@PathVariable(name = "id") UUID id)
    {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = manager.getProduct(id);
        mav.addObject("products",product);
        return mav;
    }
    @RequestMapping("/product/set")
    public String showNewProductsForm(Model model)
    {
        Product product = new Product();
        model.addAttribute("product",product);
        return "new_product";
    }
}
