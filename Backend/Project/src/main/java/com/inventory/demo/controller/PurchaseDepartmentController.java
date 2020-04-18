package com.inventory.demo.controller;

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
    public void updateProduct(@RequestBody Product product) throws Exception{

        try{
            manager.getProduct(product.getProductID());
        }catch (Exception e){
            throw new Exception("No object found with this ID");
        }

        manager.saveProduct(product);
    }

}
