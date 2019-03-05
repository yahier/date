package com.yahier.date.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 增加thymeleaf支持后，默认的路径映射与默认不同
 */
@Controller
@RequestMapping("/view")
public class ViewController {
    private final String TAG = "ViewController";


    /**
     * 增加了thymeleaf后，路径有所不同
     */
    @RequestMapping("/test")
    public String test1(HttpServletRequest request) {
        request.setAttribute("key", "hello world");
        return "/thymeleaf_test1";
    }

}