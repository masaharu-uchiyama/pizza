package com.example.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pizza.entity.Goods;
import com.example.pizza.repository.GoodsRepository;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

    /** レポジトリ */
    @Autowired
    GoodsRepository goodsRepository;

    @Override
    public Iterable<Goods> selectAllGoods() {
        return goodsRepository.findAll();
    }

}
