package com.yahier.date.table;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //strategy = GenerationType.AUTO
    private Long id;
    private String date;//日期
    private String title;//标题
    private String detailDesc;//详细介绍
    private String address;//地址
    private String activityPhotoUrl;//活动图片
    private int expectMaleCount;//预期男性人数
    private int expectFemaleCount;//预期女性人数
    private int signUpMaleCount;//报名男性人数
    private int signUpFemaleCount;//报名女性人数


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getActivityPhotoUrl() {
        return activityPhotoUrl;
    }

    public void setActivityPhotoUrl(String activityPhotoUrl) {
        this.activityPhotoUrl = activityPhotoUrl;
    }

    public int getExpectMaleCount() {
        return expectMaleCount;
    }

    public void setExpectMaleCount(int expectMaleCount) {
        this.expectMaleCount = expectMaleCount;
    }

    public int getExpectFemaleCount() {
        return expectFemaleCount;
    }

    public void setExpectFemaleCount(int expectFemaleCount) {
        this.expectFemaleCount = expectFemaleCount;
    }

    public int getSignUpMaleCount() {
        return signUpMaleCount;
    }

    public void setSignUpMaleCount(int signUpMaleCount) {
        this.signUpMaleCount = signUpMaleCount;
    }

    public int getSignUpFemaleCount() {
        return signUpFemaleCount;
    }

    public void setSignUpFemaleCount(int signUpFemaleCount) {
        this.signUpFemaleCount = signUpFemaleCount;
    }
}
