package com.example.pizza.service;

import com.example.pizza.entity.Cart;

public interface CartService {
    /** カートを全件検索. */
    Iterable<Cart> selectAllCart();
    /** カートに商品を追加 */
    void insertCart(Cart cart);
}
