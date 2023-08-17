package com.example.pizza.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pizza.entity.Sessions;
import com.example.pizza.repository.SessionsRepository;

@Service
@Transactional
public class SessionsServiceImpl implements SessionsService {
    @Autowired
    private SessionsRepository repository;

    @Override
    public void reInsertSessions(Sessions sessions) {
        deleteSessionsBySessionId(sessions.getSessionId());
        insertSessions(sessions);
    }

    @Override
    public String selectUserIdBySessionId(String sessionId) {
        Optional<Sessions> sessions = repository.findById(sessionId);

        return sessions.get().getUserId();
    }

    /**
     * セッションIDを登録する.
     * @param sessions セッションエンティティ
     */
    private void insertSessions(Sessions sessions) {
        repository.insertSessions(sessions.getSessionId(), sessions.getUserId());
    }

    /**
     * セッションIDを削除する.
     * @param sessionId セッションエンティティ
     */
    private void deleteSessionsBySessionId(String sessionId) {
        repository.deleteById(sessionId);
    }

}
