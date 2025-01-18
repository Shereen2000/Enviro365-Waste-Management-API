package com.enviro.assessment.grad001.shereenmokautu.repository;

import com.enviro.assessment.grad001.shereenmokautu.model.DisposalGuideLine;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DisposalGuideLineRepository extends JpaRepository<DisposalGuideLine, Long> {

    @Query("SELECT dg FROM DisposalGuideLine dg WHERE dg.wasteCategory = ?1")
    List<DisposalGuideLine> findByWasteCategory(WasteCategory wasteCategory);
}
