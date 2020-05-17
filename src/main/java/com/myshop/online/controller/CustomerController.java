package com.myshop.online.controller;

import com.myshop.online.dto.CustomerRegisterForm;
import com.myshop.online.exception.CustomerNotFoundException;
import com.myshop.online.model.Customer;
import com.myshop.online.model.PasswordResetToken;
import com.myshop.online.repository.CustomerRepository;
import com.myshop.online.repository.ResetRepository;
import com.myshop.online.service.CustomerService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.UUID;

@Controller
@RequestMapping
@AllArgsConstructor
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    private final CustomerRepository repository;
    private final ResetRepository resetRepo;

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
    @GetMapping("/forgot-password")
    public String pageForgotPassword(Model model) {
        return "forgot";
    }

    @PostMapping("/forgot-password")
    public String submitForgotPasswordPage(@RequestParam("email") String email,
                                           RedirectAttributes attributes) {

        if (!repository.existsByEmail(email)) {
            attributes.addFlashAttribute("errorText", "Entered email does not exist!");
            return "redirect:/";
        }

        PasswordResetToken pToken = PasswordResetToken.builder()
                .customer(repository.findByEmail(email).get())
                .token(UUID.randomUUID().toString())
                .build();

        resetRepo.deleteAll();
        resetRepo.save(pToken);

        return "redirect:/forgot-success";
    }

    @GetMapping("/forgot-success")
    public String pageResetPassword(Model model) {
        return "forgot-success";
    }

    @PostMapping("/reset-password")
    public String submitResetPasswordPage(@RequestParam("token") String token,
                                          @RequestParam("newPassword") String newPassword,
                                          RedirectAttributes attributes) {

        if (!resetRepo.existsByToken(token)) {
            attributes.addFlashAttribute("errorText", "Entered email does not exist!");
            return "redirect:/reset-password";
        }

        PasswordResetToken pToken = resetRepo.findByToken(token).get();
        Customer customer = repository.findById(pToken.getCustomer().getId());
        customer.setPassword(new BCryptPasswordEncoder().encode(newPassword));

        repository.save(customer);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(required = false, defaultValue = "false") Boolean error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }


    @ExceptionHandler(CustomerNotFoundException.class)
    public ModelAndView handleEmployeeNotFoundException(HttpServletRequest request, Exception ex) {
        logger.error("Requested URL=" + request.getRequestURL());
        logger.error("Exception Raised=" + ex);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", request.getRequestURL());

        modelAndView.setViewName("error");
        return modelAndView;
    }
}
