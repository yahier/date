package com.yahier.date.repository;

import com.yahier.date.table.ApplyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplyInfoRepository extends JpaRepository<ApplyInfo, Long> {

    //List<ApplyInfo> listForActivity(Long activityId);

    //List<ApplyInfo> listForUser(Long userId);
}
