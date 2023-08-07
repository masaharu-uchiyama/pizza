package com.example.pizza.service;

import com.example.pizza.entity.Sessions;

public interface SessionsService {
    /**
     * セッションIDを登録する.
     * @param sessions エンティティ
     */
    void insertSessions(Sessions sessions);
    /**
     * セッションIDを削除する.
     * @param sessionId セッションID
     */
    void deleteSessionsBySessionId(String sessionId);

    /**
     * セッションIDを再登録する.<br>
     * 登録前に該当のセッションIDを削除する
     * @param sessions
     */
    void reInsertSessions(Sessions sessions);
}
