package com.example.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.pizza.entity.Cart;
import com.example.pizza.repository.CartRepository;

public class CartServiceImpl implements CartService {
    /** レポジトリ */
    @Autowired
    CartRepository cartRepository;

    @Override
    public Iterable<Cart> selectAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public void insertCart(Cart cart) {
        cartRepository.save(cart);
    }
}
