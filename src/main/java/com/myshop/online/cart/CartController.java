package com.myshop.online.cart;

import com.myshop.online.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
class CartController {

    @GetMapping("/cart")
    public String cart(Model model, @SessionAttribute(name = Constants.CART_ID, required = false) List<Product> cart) {
        if (cart != null) {
            model.addAttribute("products", cart);
        }
        return "cart";
    }

    // это метод для асинхронных запросов
    // демонстрация добавления в "корзину" через параметр @SessionAttribute cart_model
    @PostMapping("/cart")
    @ResponseBody
    public boolean addToListRest(@RequestParam Product product, @SessionAttribute(name = Constants.CART_ID, required = false) List<Product> cart) {
        if (cart != null) {
            cart.add(product);
        }

        return true;
    }


    @GetMapping("/cart/add")
    public String cartAdd(Model model) {
        return "cart";
    }
    // метод для добавления в "корзину" через форму
    // демонстрация добавления через объект HttpSession session
    @PostMapping("/cart/add")
    public String addToList(@RequestParam Product product, String value, HttpSession session) {
        if (session != null) {
            var attr = session.getAttribute(Constants.CART_ID);
            if (attr == null) {
                session.setAttribute(Constants.CART_ID, new ArrayList<Product>());
            }
            try {
                var list = (List<Product>) session.getAttribute(Constants.CART_ID);
                list.add(product);
            } catch (ClassCastException ignored) {

            }
        }

        return "redirect:/cart";
    }

    // в идеале это должно быть @DeleteMapping, но web-формы не поддерживают
    // запросы с методами отличными от get и post
    // по этому у нас адрес метода немного "странный" :)
    @PostMapping("/cart/empty")
    public String emptyCart(HttpSession session) {
        session.removeAttribute(Constants.CART_ID);

        return "redirect:/cart";
    }
}
