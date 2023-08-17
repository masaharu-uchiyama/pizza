package com.example.pizza.service;

import com.example.pizza.entity.Sessions;

public interface SessionsService {

    /**
     * セッションIDを再登録する.<br>
     * 登録前に該当のセッションIDを削除する
     * @param sessions セッションエンティティ
     */
    void reInsertSessions(Sessions sessions);

    /**
     * ユーザーIDを検索
     * 条件値：セッションID
     * @param sessionId セッションID
     * @return セッション
     */
    String selectUserIdBySessionId(String sessionId);
}
