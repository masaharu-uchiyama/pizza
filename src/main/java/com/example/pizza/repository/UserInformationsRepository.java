package com.example.pizza.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.pizza.entity.UserInformations;

@Repository
public interface UserInformationsRepository extends CrudRepository<UserInformations, String> {
    /**
     * 入力したアカウントを検索.<br>
     * ユーザーID、パスワードを条件にする
     * @param userId ユーザーId
     * @param password パスワード
     * @return 検索結果
     */
    @Query(   "SELECT * "
            + "FROM user_infomations "
            + "WHERE user_id = :userId "
            +   "AND password = :password")
    UserInformations selectByUserIdAndPassword(
            @Param("userId") String userId, @Param("password") String password);
    
}
