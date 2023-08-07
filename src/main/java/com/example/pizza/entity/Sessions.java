package com.example.pizza.entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sessions {
    /** セッションID */
    @Id
    private String sessionId;
    /** ユーザーID */
    private String userId;

}
