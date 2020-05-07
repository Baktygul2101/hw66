package com.myshop.online.controller;



import com.myshop.online.model.Product;
import com.myshop.online.repository.CategoryRepository;
import com.myshop.online.repository.ProductRepository;
import com.myshop.online.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/categories")
//@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categRepository;


}

