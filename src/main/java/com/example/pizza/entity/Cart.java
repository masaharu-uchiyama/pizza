package com.example.pizza.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@IdClass(CartKey.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    /** ユーザーID */
    private String userId;
    @Id
    /** 商品ID */
    private Integer goodsId;
    /** 数量 */
    private Integer quantity;
}
