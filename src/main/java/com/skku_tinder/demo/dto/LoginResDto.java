package com.skku_tinder.demo.dto;

import com.skku_tinder.demo.domain.User;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class LoginResDto {

    private final Long userID;
    private final List<String> roles;

    public LoginResDto(User user) {
        this.userID = user.getId();
        this.roles = user.getGrades();
    }
}
