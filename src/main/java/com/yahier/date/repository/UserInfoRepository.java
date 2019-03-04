package com.yahier.date.repository;

import com.yahier.date.table.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    //public List<UserInfo> findAllByGender(int gender);
}
