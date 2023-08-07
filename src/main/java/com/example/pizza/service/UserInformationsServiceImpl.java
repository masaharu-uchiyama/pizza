package com.example.pizza.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pizza.entity.UserInformations;
import com.example.pizza.form.LoginForm;
import com.example.pizza.repository.UserInformationsRepository;

@Service
@Transactional
public class UserInformationsServiceImpl implements UserInformationsService {
    /** Repository：注入 */
    @Autowired
    UserInformationsRepository repository;

    @Override
    public boolean canLogin(LoginForm loginForm) {
        // webからの入力
        String userId = loginForm.getUserId();
        String password = loginForm.getPassword();

        UserInformations selectedUser = repository.selectByUserIdAndPassword(userId, password);
        // ユーザー情報を取得できなかった場合
        if (selectedUser == null) {
            return false;
        }
        return true;
    }

    @Override
    public void insertUser(UserInformations userInformation) {
        repository.save(userInformation);
    }

    @Override
    public Optional<UserInformations> selectUserByUserId(String userId) {
        Optional<UserInformations> user = repository.findById(userId);
        return user;
    }

}
