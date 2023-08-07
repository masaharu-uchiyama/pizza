package com.example.pizza.service;

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
    public void insertSessions(Sessions sessions) {
        repository.insertSessions(sessions.getSessionId(), sessions.getUserId());
    }

    @Override
    public void deleteSessionsBySessionId(String sessionId) {
        repository.deleteById(sessionId);
    }

    @Override
    public void reInsertSessions(Sessions sessions) {
        deleteSessionsBySessionId(sessions.getSessionId());
        insertSessions(sessions);
    }

}
