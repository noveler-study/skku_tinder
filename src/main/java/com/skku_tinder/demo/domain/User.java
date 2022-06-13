package com.skku_tinder.demo.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Entity
@Table(name = "users")
@RequiredArgsConstructor
public class User implements UserDetails {

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
//  @Column(nullable = false)
    private String username;

//  @Column(nullable = false)
    private String password;

//  @Column(nullable = false)
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> grades = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grades.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


//    @Column(nullable = true)
    private Long kakaoId;

    @Builder
    public User(String username, String password, String email, List<String> grades) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.grades = grades;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String nickname, String encodedPassword, String email, Long kakaoId, List<String> grades) {
        this.username = nickname;
        this.password = encodedPassword;
        this.email = email;
        this.kakaoId = kakaoId;
        this.grades = grades;
    }


}
