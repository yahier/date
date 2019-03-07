package com.yahier.date.repository;

import com.yahier.date.table.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    /**
     * 根据性别 查找列表
     */
    @Query("select t from UserInfo t where t.gender = ?1")
    List<UserInfo> getListBy(int gender);

    /**
     * 根据姓名和手机号码，查找是否有已经存在   测试OK，只是返回列表不够好，应该返回
     */
    @Query("select t from UserInfo t where t.name = ?1 and t.phoneNo=?2")
    List<UserInfo> getListBy(String name, String phoneNo);
}
