package com.myshop.online.controller;



import com.myshop.online.exception.CustomerNotFoundException;
import com.myshop.online.model.Customer;
import com.myshop.online.model.Product;
import com.myshop.online.repository.CategoryRepository;
import com.myshop.online.repository.ProductRepository;
import com.myshop.online.service.ProductService;
import lombok.var;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static java.util.stream.Collectors.toList;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    ProductRepository repo;
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryRepository categoryRepository;

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

    @RequestMapping(value="/registration",method= RequestMethod.GET)
    public String registerPage(Model model){
        model.addAttribute("customer", new Customer());
        return "register";
    }
    @RequestMapping(value="/registerSuccess",method=RequestMethod.POST)
    public String registerSuccess(@Valid @ModelAttribute("user") Customer user, BindingResult result) {

        if(result.hasErrors()){
            return "register";
        }
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
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


    @GetMapping("/search")
    public String main(
            @RequestParam(required = false, defaultValue = "") String filter,
            Model model,
            @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Page<Product> page;

        if (filter != null && !filter.isEmpty()) {
            page = repo.findByName(filter, pageable);
        } else {
            page = repo.findAll(pageable);
        }

        model.addAttribute("page", page);
        model.addAttribute("url", "/");
        model.addAttribute("filter", filter);

        return "search";
    }

}
