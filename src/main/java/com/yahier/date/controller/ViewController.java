package com.yahier.date.controller;

import com.yahier.date.table.UserInfo;
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

    /**
     * 增加了thymeleaf后，路径有所不同
     */
    @RequestMapping("/test2")
    public String test2(HttpServletRequest request) {
        request.setAttribute("key", "hello world");
        return "redirect:/index.html";
    }

    @RequestMapping("/test3")
    public String test3(HttpServletRequest request) {
        return "/index";
    }

    /**
     * 个人信息编辑页面
     */
    @RequestMapping("/userEdit")
    public String userInfo(HttpServletRequest request, UserInfo userInfo) {
        request.setAttribute("name", userInfo.getName());
        return "user_info_edit";
    }

    /**
     * 个人信息编辑页面
     */
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, UserInfo userInfo) {
        request.setAttribute("name", userInfo.getName());
        return "upload";
    }


}
