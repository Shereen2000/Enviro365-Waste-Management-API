package com.enviro.assessment.grad001.shereenmokautu.repository;

import com.enviro.assessment.grad001.shereenmokautu.model.WasteCategory;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface WasteProductRepository extends JpaRepository<WasteProduct, Long> {

    @Query("SELECT wp FROM WasteProduct wp WHERE wp.wasteCategory = ?1")
    List<WasteProduct> findByWasteCategory(WasteCategory wasteCategory);

    @Query("SELECT wp FROM WasteProduct wp WHERE wp.name = ?1")
    Optional<WasteProduct> findWasteProductByName(String name);
}
