package com.yahier.date.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private final String TAG = "TestController";

    @RequestMapping("/test1")
    String test1() {
        return TAG + " test1";
    }
}
