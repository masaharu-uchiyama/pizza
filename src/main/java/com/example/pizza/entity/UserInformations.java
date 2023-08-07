package com.example.pizza.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformations implements Persistable<String> {
    /** ユーザーId */
    @Id
    private String userId;
    /** 名前 */
    private String name;
    /** パスワード */
    private String password;
    /** 住所 */
    private String address;
    /** 電話番号 */
    private String phoneNumber;
    /** メールアドレス */
    private String mailAddress;
    /** 更新フラグ */
//    private boolean canInsert;

    @Override
    public String getId() {
        return userId;
    }
    @Override
    public boolean isNew() {
        return true;
    }
}
