package com.example.pizza.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pizza.entity.Cart;

/**
 * 商品リポジトリ
 *
 */
@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

}
