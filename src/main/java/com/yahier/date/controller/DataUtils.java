package com.yahier.date.controller;

import com.yahier.date.table.UserInfo;

public class DataUtils {

    public static String verify(UserInfo userInfo) {
        if (isEmpty(userInfo.getName()))
            return "姓名格式不对";
        if (isEmpty(userInfo.getPhoneNo()))
            return "手机号码格式不对";
        return null;
    }

    private static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }
}
