package com.yahier.date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
@SpringBootApplication
public class DateApplication {

    public static void main(String[] args) {
        SpringApplication.run(DateApplication.class, args);
    }

    @RequestMapping("/")
    public String test1(HttpServletRequest request) {
        return "/welcome";
    }
}
