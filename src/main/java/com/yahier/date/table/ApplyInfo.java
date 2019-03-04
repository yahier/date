package com.yahier.date.table;

import javax.persistence.*;

/**
 * 报名信息表
 */
@Entity
@NamedQuery(name = "ApplyInfo.listForActivity", query = "select t from ApplyInfo t where t.activityId = ?1")
@NamedQuery(name = "ApplyInfo.listForUser", query = "select t from ApplyInfo t where t.userId = ?1")
public class ApplyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //strategy = GenerationType.AUTO
    private Long id;
    private long userId;
    private long activityId;
    private String name;
    private String phoneNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
