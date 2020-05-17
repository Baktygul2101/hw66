package com.myshop.online.cart;

import com.myshop.online.model.Order;
import com.myshop.online.model.Product;

import javax.persistence.ManyToOne;

final class Constants {
    static final String CART_ID = "_cart_";

    @ManyToOne
    private Product product;
    @ManyToOne
    private Order order;
}
