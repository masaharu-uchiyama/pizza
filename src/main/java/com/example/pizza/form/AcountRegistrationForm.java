package com.example.pizza.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 会員登録Formクラス
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcountRegistrationForm {
    /** ユーザーID */
    private String userId;
    /** パスワード */
    private String password;
    /** 電話番号 */
    private String phoneNumber;
    /** 住所 */
    private String adrress;
}
