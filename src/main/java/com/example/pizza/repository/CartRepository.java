package com.example.pizza.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pizza.entity.Cart;
import com.example.pizza.entity.CartKey;

import dto.CartDto;

/**
 * 商品リポジトリ
 *
 */
@Repository
public interface CartRepository extends CrudRepository<Cart, CartKey> {

    /**
     * カート情報を検索<br>
     * <注意><br>
     *  goods_nameにエイリアスを付けるとエラー<br>
     *  quantityはエイリアスを付けないとエラー
     * @param userId ユーザーID
     * @return ピザ名、値段、個数
     */
    @Query( "SELECT goods.goods_name,"
           +       "goods.price,"
           +       "cart.quantity AS quantity "
           +  "FROM cart "
           + "INNER JOIN goods "
           +    "ON cart.goods_id = goods.goods_id "
           + "WHERE cart.user_id = :userId")
    List<CartDto> selectCartList(@Param(value = "userId") String userId);

    /**
     * カートに商品を追加する
     * @param userId ユーザーID
     * @param goodsId 商品ID
     * @param quantity 数量
     */
    @Query("INSERT INTO `cart` (`user_id`, `goods_id`, `quantity`) "
            + "VALUES(:userId, :goodsId, :quantity)")
     void insertCart(@Param(value = "userId") String userId,
                     @Param(value = "goodsId") int goodsId,
                     @Param(value = "quantity") int quantity);
}
