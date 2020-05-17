package com.myshop.online.controller;


import com.myshop.online.model.Product;
import com.myshop.online.repository.CategoryRepository;
import com.myshop.online.repository.ProductRepository;
import com.myshop.online.service.ProductService;
import com.myshop.online.service.PropertiesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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



    private static <T> void constructPageable(Page<T> list, int pageSize, Model model, String uri) {
        if (list.hasNext()) {
            model.addAttribute("nextPageLink", constructPageUri(uri, list.nextPageable().getPageNumber(), list.nextPageable().getPageSize()));
        }

        if (list.hasPrevious()) {
            model.addAttribute("prevPageLink", constructPageUri(uri, list.previousPageable().getPageNumber(), list.previousPageable().getPageSize()));
        }

        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());
        model.addAttribute("items", list.getContent());
        model.addAttribute("defaultPageSize", pageSize);
    }

    private static String constructPageUri(String uri, int page, int size) {
        return String.format("%s?page=%s&size=%s", uri, page, size);
    }

    @Autowired
    ProductRepository repo;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    private final PropertiesService propertiesService;

    @GetMapping("/")
   public String mainPage(Model model) {
        return "index";
    }


    @RequestMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", repo.findAll());
        return "products";
    }

    @RequestMapping("/product/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }

    @RequestMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "index";
    }





    @GetMapping("/products")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Product> products = productRepository.findAll();

        if (filter != null && !filter.isEmpty()) {
            products = productRepository.findAllByNameIgnoreCase(filter);
        } else {
            products = productRepository.findAll();
        }

        model.addAttribute("products", products);
        model.addAttribute("filter", filter);

        return "products";
    }

    @ExceptionHandler(BindException.class)
    private ResponseEntity<Object> handleBindExceptionResponseEntity(BindException ex) {
        var apiFieldErrors = ex.getFieldErrors()
                .stream()
                .map(fe -> String.format("%s ->%s", fe.getField(), fe.getDefaultMessage()))
                .collect(toList());

        return ResponseEntity.unprocessableEntity()
                .body(apiFieldErrors);
    }
}