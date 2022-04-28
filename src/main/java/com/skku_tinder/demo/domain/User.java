package com.skku_tinder.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "users")
@RequiredArgsConstructor
public class User {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
//    @Column(nullable = false)
    private String username;

//    @Column(nullable = false)
    private String password;

//    @Column(nullable = false)
    private String email;

//    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

//    @Column(nullable = true)
    private Long kakaoId;

    public User(String username, String password, String email, UserRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(String nickname, String encodedPassword, String email, UserRole role, Long kakaoId) {
        this.username = nickname;
        this.password = encodedPassword;
        this.email = email;
        this.role = role;
        this.kakaoId = kakaoId;
    }
}
