package com.yahier.date.repository;

import com.yahier.date.table.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long>{
}
