package com.lahee.psSocial.my.controller;

import ch.qos.logback.core.model.Model;
import com.lahee.psSocial.my.domain.dto.user.UserRequestDto;
import com.lahee.psSocial.my.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class userController {
    private final UserService userService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        // 회원가입 폼을 보여주기 위해 signup.html을 반환합니다.
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute UserRequestDto userRequestDto) {
        userService.signUp(userRequestDto);
        return "redirect:/login";
    }

}
