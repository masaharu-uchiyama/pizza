package com.example.pizza.service;

import com.example.pizza.entity.Goods;

/**
 * サービスクラス
 *
 */
public interface GoodsService {
    /** 商品を全件検索. */
    Iterable<Goods> selectAllGoods();
}
