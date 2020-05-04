package com.myshop.online.controller;



import com.myshop.online.exception.exception.CustomerNotFoundException;
import com.myshop.online.model.Customer;
import com.myshop.online.model.Product;
import com.myshop.online.repository.ProductRepository;
import lombok.var;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static java.util.stream.Collectors.toList;

@Controller
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    ProductRepository repo;

    @GetMapping("/")
    public String mainPage(Model model) {
        return "index";
    }

   /* @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }*/

    @RequestMapping(value="/registration",method= RequestMethod.GET)
    public String registerPage(Model model){
        model.addAttribute("customer", new Customer());
        return "registration";
    }
    @RequestMapping(value="/registerSuccess",method=RequestMethod.POST)
    public String registerSuccess(@Valid @ModelAttribute("user") Customer user, BindingResult result) {

        if(result.hasErrors()){
            return "registration";
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
 //  <p>${pr.id} - ${pr.name} - ${pr.image} - ${pr.quantity} -${pr.description}-${pr.price}</p>
  //  @GetMapping
  /*  public String root(Model model) {
        model.addAttribute("products", repo.findAll());
        return "index";
    }*/



 /*   @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("products", repo.findAll());
        return "index";
    }

    @GetMapping("/jql/{name}")
    public String getMainPageJql(Model model, @PathVariable("name") String name) {
        model.addAttribute("products", repo.getByName(name));
        return "index";
    }*/

}
