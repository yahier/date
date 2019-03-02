package com.yahier.date.table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserInfo {
    //将策略换成GenerationType.IDENTITY 之后，id才开始自增长，而用GenerationType.AUTO不行
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //strategy = GenerationType.AUTO
    private Long id;

    private String name;//姓名
    private String photoUrl;//图片
    private String phoneNo;//手机号码
    private String birthDate;//出生年月
    private String career;//职业
    private int heightCM;//身高
    private int weightKG;//体重
    //private List<String> listHobby;//兴趣爱好
    private String remark;//备注


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public int getHeightCM() {
        return heightCM;
    }

    public void setHeightCM(int heightCM) {
        this.heightCM = heightCM;
    }

    public int getWeightKG() {
        return weightKG;
    }

    public void setWeightKG(int weightKG) {
        this.weightKG = weightKG;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

//    public List<String> getListHobby() {
//        return listHobby;
//    }
//
//    public void setListHobby(List<String> listHobby) {
//        this.listHobby = listHobby;
//    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}
