package com.yahier.date.controller;

import com.yahier.date.table.Activity;
import com.yahier.date.table.UserInfo;

public class DataUtils {

    public static String verify(UserInfo userInfo) {
        if (isEmpty(userInfo.getName()))
            return "姓名格式不对";
        if (isEmpty(userInfo.getPhoneNo()))
            return "手机号码格式不对";
        return null;
    }

    public static String verifyFull(UserInfo userInfo) {
        if (isEmpty(userInfo.getName()))
            return "姓名格式不对";
        if (isEmpty(userInfo.getPhoneNo()))
            return "手机号码格式不对";
        if (isEmpty(userInfo.getBirthDate()))
            return "出生日期格式不对";
        if (isEmpty(userInfo.getCareer()))
            return "职业格式不对";
        return null;
    }

    public static String verify(Activity activity) {
        if (isEmpty(activity.getTitle()))
            return "标题格式不对";
        if (isEmpty(activity.getAddress()))
            return "地址格式不对";
        if (isEmpty(activity.getDate()))
            return "日期格式不对";
        if (0 >= activity.getExpectFemaleCount())
            return "预期女性人数不对";
        if (0 >= activity.getExpectMaleCount())
            return "预期男性人数不对";
        if (isEmpty(activity.getDetailDesc()))
            return "详情格式不对";
        return null;
    }


    private static boolean isEmpty(String str) {
        return str == null || str.equals("");
    }
}
