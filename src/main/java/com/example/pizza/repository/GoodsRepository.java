package com.example.pizza.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.pizza.entity.Goods;

/**
 * 商品リポジトリ
 *
 */
@Repository
public interface GoodsRepository extends CrudRepository<Goods, Integer> {

}
