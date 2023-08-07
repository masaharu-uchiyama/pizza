package com.example.pizza.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ログインFormクラス
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginForm {
    /** ユーザーId */
    private String userId;
    /** パスワード */
    private String password;
}
