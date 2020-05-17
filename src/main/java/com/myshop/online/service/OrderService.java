package com.myshop.online.service;

import com.myshop.online.model.Order;
import com.myshop.online.model.Product;
import com.myshop.online.model.ProductInCart;

import javax.persistence.EntityManager;

public class OrderService {
    private EntityManager entityManager;

    public Order createOrder(){
        Order order = new Order();
        entityManager.persist(order);
        return order;
    }


    public boolean addToCart(int productId, int orderId,int quantity){
        Product product= entityManager.find(Product.class, productId);
        if (product==null){
            return false;
        }
        Order order= entityManager.find(Order.class, orderId);
        if (order==null){
            return false;
        }
        ProductInCart inCart= new ProductInCart();
        inCart.setOrder(order);
        inCart.setProduct(product);
        inCart.setQuantity(quantity);
        entityManager.persist(inCart);
        return true;

    }
}
