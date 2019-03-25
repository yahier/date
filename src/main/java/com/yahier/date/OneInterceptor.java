package com.yahier.date;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Enumeration;

public class OneInterceptor implements HandlerInterceptor {
    private final String TAG = "OneInterceptor";

    /**
     * 在Controller处理之前被拦截,返回true，则继续往下运行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(TAG + " preHandle 放行");

        Enumeration<String> rations = request.getParameterNames();
        System.out.println("requestSize：" + request.getParameterMap().size());

        while (rations.hasMoreElements()) {
            String key = rations.nextElement();
            String value = request.getParameter(key);

            System.out.println("key:" + key + "  value:" + value);

        }

        String url = request.getRequestURL().toString();
        System.out.println(url);

        //2.获取客户端请求的资源部分的名称
        String uri = request.getRequestURI().toString();
        System.out.println(uri);

        //3.获取请求行的参数部分
//        String qStr = request.getQueryString().toString();
//        System.out.println(qStr);

        //4.获取请求客户端的ip地址
        String ip = request.getRemoteAddr();
        System.out.println(ip);

        //5.获取客户机的请求方式
        String method = request.getMethod();
        System.out.println(method);

        //6.获取当前web应用的名称,不是工程名
        String webName = request.getContextPath();
        System.out.println(webName);    //7.给一个请求头名称，获取其值
        String host = request.getHeader("Host");
        System.out.println(host);

        //8.获取所有请求头名字组成的枚举
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            String values = request.getHeader(name);
            System.out.println(name + ":" + values);
        }

//        if (true) {
//            returnErrorResponse(response);
//            return false;
//        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println(TAG + "  afterCompletion");
    }

    public void returnErrorResponse(HttpServletResponse response) {
        response.setCharacterEncoding("utf-8");
        response.setContentType("test/json");
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write((TAG + " returnErrorResponse 发生了错误").getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
