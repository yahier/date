package com.yahier.date.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/test")
public class TestController {
    private final String TAG = "TestController";

    @RequestMapping("/test1")
    String test1() {
        return TAG + " test1";
    }

    @RequestMapping("/index")
    String index(Model model) {
        return "index";
    }

    @RequestMapping("/login")
    String login() {
        return "login";
    }
}
