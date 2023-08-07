package com.example.pizza.repository;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.pizza.entity.Sessions;

public interface SessionsRepository extends CrudRepository<Sessions, String> {
    /**
     * セッションIDをインサート
     * @param sessionId セッションID
     * @param userId ユーザーID
     */
    @Modifying
    @Query("INSERT INTO sessions(`session_id`, `user_id`) "
            + "VALUES(:sessionId, :userId)")
    void insertSessions(@Param("sessionId") String sessionId, @Param("userId") String userId);
}
