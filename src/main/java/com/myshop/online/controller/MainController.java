package com.myshop.online.controller;


import com.myshop.online.model.Product;
import com.myshop.online.repository.CategoryRepository;
import com.myshop.online.repository.ProductRepository;
import com.myshop.online.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping
@AllArgsConstructor
public class MainController {


    @Autowired
    ProductRepository repo;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String mainPage(Model model) {
        return "index";
    }

   @RequestMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", repo.findAll());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }


//для поиска

    @GetMapping("/products")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Product> products = productRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            products = productRepository.findAllByName(filter);
        } else {
            products = productRepository.findAll();
        }
        model.addAttribute("products", products);
        model.addAttribute("filter", filter);
        return "products";
    }

   /* @RequestMapping("/search") нужно доработать форму
    public ModelAndView search(@RequestParam String keyword) {
        List<Product> result = productService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;
    }*/

    @ExceptionHandler(BindException.class)
    private ResponseEntity<Object> handleBindExceptionResponseEntity(BindException ex){
        var apiFieldErrors=ex.getFieldErrors()
                .stream()
                .map(fe->String.format("%s ->%s",fe.getField(), fe.getDefaultMessage()))
                .collect(toList());

        return ResponseEntity.unprocessableEntity()
                .body(apiFieldErrors);
    }

}
