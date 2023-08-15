package com.example.pizza.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartKey implements Serializable {
    /** ユーザーID */
    private String userId;
    /** 商品ID */
    private Integer goodsId;
}
