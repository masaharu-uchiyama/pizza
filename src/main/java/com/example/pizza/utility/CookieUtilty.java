package com.example.pizza.utility;

import javax.servlet.http.Cookie;

/**
 * クッキー共通クラス.
 *
 */
public class CookieUtilty {
    /**
     * クッキーを作成.<br>
     * 有効期限は3分
     * @param name 名前
     * @param value 値
     * @return クッキー
     */
    public static Cookie createCookie(String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(3 * 60);

        return cookie;
    }
}
