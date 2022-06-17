package com.skku_tinder.demo.controller;

import com.skku_tinder.demo.dto.TokenDto;
import com.skku_tinder.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @GetMapping("/login/kakao/callback")
    public String login(@RequestParam String code)
    {
        TokenDto token = userService.kakaoLogin(code);
        return "redirect:/";
    }

    @GetMapping("/")
    public String login2()
    {
        return "index";
    }
}
