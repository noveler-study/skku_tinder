package com.skku_tinder.demo.controller;

import com.skku_tinder.demo.domain.User;
import com.skku_tinder.demo.dto.LoginResDto;
import com.skku_tinder.demo.dto.SignupReqDto;
import com.skku_tinder.demo.dto.TokenDto;
import com.skku_tinder.demo.dto.TokenReqDto;
import com.skku_tinder.demo.repository.UserRepository;
import com.skku_tinder.demo.security.JwtTokenProvider;
import com.skku_tinder.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserService userService;

    // 회원가입
    @PostMapping("/join")
    public Long join(@RequestBody Map<String, String> user) {

        SignupReqDto signupReqDto = SignupReqDto.builder()
                .username(user.get("username"))
                .password(passwordEncoder.encode(user.get("password"))).build();

        return userService.signup(signupReqDto);

    }


    @GetMapping("/user")
    public String user(@RequestBody Map<String, String> user)
    {
        return "hello";
    }


    // 로그인
    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> user) {
        System.out.println("controller 시작");
        TokenDto tokenDto = userService.login(user.get("username"), user.get("password"));
        return tokenDto.toString();
    }

    @PostMapping("/reissue")
    public String reissue(@RequestBody Map<String, String> req)
    {

        TokenReqDto tokenReqDto = TokenReqDto.builder()
                .accessToken(req.get("accessToken"))
                .refreshToken(req.get("refreshToken"))
                .build();
        return userService.reissue(tokenReqDto);
    }
}
