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

    /**
     * 不用配置viewResolver，直接到达的路径是 resource/static
     */
    @RequestMapping("/index")
    public String index() {
        return "/index.html";
    }

    @RequestMapping("/login")
    String login() {
        return "/login.html";
    }
}
