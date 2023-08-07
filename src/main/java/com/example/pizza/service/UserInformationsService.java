package com.example.pizza.service;

import java.util.Optional;

import com.example.pizza.entity.UserInformations;
import com.example.pizza.form.LoginForm;

public interface UserInformationsService {
    /**
     * ログイン判定.
     * @param loginForm ログインフォーム
     * @return ログイン判定結果
     */
    boolean canLogin(LoginForm loginForm);

    /**
     * ユーザー検索.
     * 条件：ユーザーID
     * @param userId ユーザーID
     * @return 検索結果
     */
    Optional<UserInformations> selectUserByUserId(String userId);

    /**
     * ユーザー登録.
     * ユーザーIDをnullにして登録 → ユーザーIDを設定して更新
     * @param UserInformation ユーザー情報クラス
     */
    void insertUser(UserInformations userInformation);

}
