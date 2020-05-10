package com.myshop.online.controller;


import com.myshop.online.dto.CustomerRegisterForm;
import com.myshop.online.exception.CustomerNotFoundException;
import com.myshop.online.model.Product;
import com.myshop.online.repository.CategoryRepository;
import com.myshop.online.repository.ProductRepository;
import com.myshop.online.service.CustomerService;
import com.myshop.online.service.ProductService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping
@AllArgsConstructor
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

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

    @RequestMapping("/product/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }
    @RequestMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categories";
    }


    @ExceptionHandler(CustomerNotFoundException.class)
    public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex){
        logger.error("Requested URL="+request.getRequestURL());
        logger.error("Exception Raised="+ex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("error");
        return modelAndView;
    }


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
    @ExceptionHandler(BindException.class)
    private ResponseEntity<Object> handleBindExceptionResponseEntity(BindException ex){
        var apiFieldErrors=ex.getFieldErrors()
                .stream()
                .map(fe->String.format("%s ->%s",fe.getField(), fe.getDefaultMessage()))
                .collect(toList());

        return ResponseEntity.unprocessableEntity()
                .body(apiFieldErrors);
    }


    //

    private final CustomerService customerService;

    @GetMapping("/profile")
    public String pageCustomerProfile(Model model, Principal principal)
    {
        var user = customerService.getByEmail(principal.getName());
        model.addAttribute("dto", user);
        return "profile";
    }

    @GetMapping("/register")
    public String pageRegisterCustomer(Model model) {
        if (!model.containsAttribute("dto")) {
            model.addAttribute("dto", new CustomerRegisterForm());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerPage(@Valid CustomerRegisterForm customerRequestDto,
                               BindingResult validationResult,
                               RedirectAttributes attributes) {
        attributes.addFlashAttribute("dto", customerRequestDto);

        if (validationResult.hasFieldErrors()) {
            attributes.addFlashAttribute("errors", validationResult.getFieldErrors());
            return "redirect:/register";
        }
        customerService.register(customerRequestDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }


}
