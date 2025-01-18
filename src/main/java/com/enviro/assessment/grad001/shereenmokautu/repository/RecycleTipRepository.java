package com.enviro.assessment.grad001.shereenmokautu.repository;

import com.enviro.assessment.grad001.shereenmokautu.model.RecycleTip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface RecycleTipRepository extends JpaRepository<RecycleTip, Long> {

    @Query("SELECT r FROM RecycleTip r WHERE r.isActive = ?1 AND r.createdAt >= ?2")
    List<RecycleTip> findByIsActiveAndCreatedAtGreaterThanEqual(
            Boolean isActive, LocalDate createdFrom);
}
