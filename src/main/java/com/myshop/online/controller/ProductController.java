package com.myshop.online.controller;



import com.myshop.online.model.Product;
import com.myshop.online.repository.ProductRepository;
import com.myshop.online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/products")
//@RestController
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private ProductRepository productRepository;




    @PostMapping ("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping ("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

 /*   @GetMapping ("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }*/

    @GetMapping ("/idproduct/{id}")
    public Product findProductById(@PathVariable int id){
        return  service.getProductById(id);
    }

    @GetMapping ("/product/{name}")
    public Product findProductByName(@PathVariable String name){
        return  service.getProductByName(name);
    }

    @PutMapping ("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return  service.deleteProduct(id);
    }
}

