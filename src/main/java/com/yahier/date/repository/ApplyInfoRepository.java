package com.yahier.date.repository;

import com.yahier.date.table.ApplyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedQuery;
import java.util.List;

public interface ApplyInfoRepository extends JpaRepository<ApplyInfo, Long> {

    @Query("select t from ApplyInfo t where t.activityId = ?1")
    List<ApplyInfo> listForActivity(Long activityId);

    @Query("select t from ApplyInfo t where t.userId = ?1")
    List<ApplyInfo> listForUser(Long userId);
}
