package com.example.pizza.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    /** 商品ID */
    @Id
    Integer goodsId;
    /** 商品名 */
    String goodsName;
    /** 価格 */
    Integer price;
}
