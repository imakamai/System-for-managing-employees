package com.employeeproject.IT355PZVanjaCekic4835.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "redirect:http://localhost:4200/login-page";
    }
}
