package com.skku_tinder.demo.dto;

import com.skku_tinder.demo.domain.User;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;

@Data
public class SignupReqDto {
    private String username;
    private String password;
    private String email;
    private boolean admin = false;
    private String adminToken = "";

    @Builder
    public SignupReqDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User toEntity(){
        return User.builder()
                .username(username)
                .password(password)
                .grades(Collections.singletonList("ROLE_USER"))
                .build();

    }
}

