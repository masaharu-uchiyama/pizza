package com.example.pizza.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.pizza.entity.Goods;
import com.example.pizza.entity.Sessions;
import com.example.pizza.entity.UserInformations;
import com.example.pizza.form.LoginForm;
import com.example.pizza.service.GoodsService;
import com.example.pizza.service.SessionsService;
import com.example.pizza.service.UserInformationsService;
import com.example.pizza.utility.CookieUtilty;

/**
 * コントローラークラス
 *
 */
@Controller
@RequestMapping("/pizza")
public class PizzaController {

    // DI注入
    /** サービスクラス */
    @Autowired
    GoodsService goodsService;
    @Autowired
    UserInformationsService userInformationService;
    @Autowired
    SessionsService sessionsService;

    /**
     * ログイン.<br>
     * クッキーがある場合、商品一覧画面に遷移する
     * @return ログイン画面
     */
    @GetMapping
    public String login(
            @CookieValue(name = "sessionId", defaultValue = "defaultCookieValue") String sessionId) {
        // クッキーが存在しない場合
        if ("defaultCookieValue".equals(sessionId)) {
            return "login";
        }

        return "redirect:/pizza/goodsList";
    }

    /**
     * ログインチェック.
     * @param loginForm
     * @return true:商品一覧 false:ログイン画面
     */
    @PostMapping("/checkLogin")
    public String checkLogin(LoginForm loginForm, HttpServletResponse response, HttpServletRequest request) {
        // ログイン成功時、商品一覧画面に遷移
        if (userInformationService.canLogin(loginForm)) {
            String sessionId = request.getSession().getId();
            Sessions sessions = new Sessions(sessionId, loginForm.getUserId());
            sessionsService.reInsertSessions(sessions);
            response.addCookie(CookieUtilty.createCookie("sessionId", sessionId));

            return "redirect:/pizza/goodsList";
        }
        // ログイン失敗時、ログイン画面に遷移
        return "redirect:/pizza";
    }

    /**
     * アカウント登録/
     * @return アカウント登録画面
     */
    @GetMapping("/register")
    public String register() {
        return "acountRegistration";
    }

    @PostMapping("/checkRegister")
    public String checkRegister(UserInformations userInformation, HttpServletResponse response, HttpServletRequest request) {
        // ユーザーIDを条件に検索
        Optional<UserInformations> user = 
                userInformationService.selectUserByUserId(userInformation.getUserId());

        // ユーザーが被っている場合
        if (user.isPresent()) {
            return "acountRegistration";
        }

        userInformationService.insertUser(userInformation);
        String sessionId = request.getSession().getId();
        Sessions sessions = new Sessions(sessionId, userInformation.getUserId());
        response.addCookie(CookieUtilty.createCookie("sessionId", sessionId));
        sessionsService.reInsertSessions(sessions);

        return "redirect:/pizza/goodsList";
    }

    /**
     * 商品一覧画面.
     * @param model モデル
     * @return 商品一覧画面
     */
    @RequestMapping(value = "/goodsList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showGoosList(Model model) {
        //　商品全検索
        Iterable<Goods> goodsList = goodsService.selectAllGoods();
        model.addAttribute("goodsList", goodsList);

        return "goodsList";
    }

}
