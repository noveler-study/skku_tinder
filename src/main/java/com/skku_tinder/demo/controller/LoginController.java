package com.skku_tinder.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    @GetMapping("/login/oauth")
    public String login()
    {
        return "oauth test";
    }

    @RequestMapping("/")
    public String login2()
    {
        return "ok";
    }
}
