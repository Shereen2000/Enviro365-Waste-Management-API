package com.enviro.assessment.grad001.shereenmokautu.repository;

import com.enviro.assessment.grad001.shereenmokautu.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {

    @Query("SELECT wc FROM WasteCategory wc WHERE wc.name = ?1")
    Optional<WasteCategory> findWasteCategoryByName(String name);

}
