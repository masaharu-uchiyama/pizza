package com.example.pizza.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    /** カートID */
    private Integer cartId;
    /** ユーザーID */
    private String userId;
    /** 商品ID */
    private Integer goodsId;
    /** 数量 */
    private Integer quantity;
}
