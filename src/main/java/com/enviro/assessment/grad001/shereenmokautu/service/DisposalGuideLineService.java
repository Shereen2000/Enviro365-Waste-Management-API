package com.enviro.assessment.grad001.shereenmokautu.service;

import com.enviro.assessment.grad001.shereenmokautu.model.DisposalGuideLine;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteCategory;
import com.enviro.assessment.grad001.shereenmokautu.repository.DisposalGuideLineRepository;
import com.enviro.assessment.grad001.shereenmokautu.repository.WasteCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class DisposalGuideLineService {
    private final DisposalGuideLineRepository disposalGuideLineRepository;
    private final WasteCategoryRepository wasteCategoryRepository;

    @Autowired
    public DisposalGuideLineService
            (DisposalGuideLineRepository disposalGuideLineRepository,
             WasteCategoryRepository wasteCategoryRepository)
    {
        this.disposalGuideLineRepository = disposalGuideLineRepository;
        this.wasteCategoryRepository = wasteCategoryRepository;
    }

    //retrieving all disposal guidelines_______________ ________________________________________________________________

    public List<DisposalGuideLine> getAllDisposalGuidelines()
    {
        return disposalGuideLineRepository.findAll();
    }

    //retrieving a disposal guideline by id ____________________________________________________________________________

    public DisposalGuideLine getDisposalGuidelineById(Long disposalGuideLineId)
    {
        return disposalGuideLineRepository.findById(disposalGuideLineId)
                .orElseThrow(()-> new IllegalStateException("Guideline of id: "+disposalGuideLineId+" could not be"+
                        " found"));
    }

    //retrieving disposal guidelines by waste category _________________________________________________________________

    public List<DisposalGuideLine>  getByWasteCategory(Long wasteCategoryId)
    {
        WasteCategory existingWasteCategory = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(() -> new IllegalStateException("The waste category of Id: " +
                        wasteCategoryId + " does not exist"));

        return disposalGuideLineRepository.findByWasteCategory(existingWasteCategory);
    }

    //Add a new waste disposal guideline _______________________________________________________________________________

    @Transactional
    public DisposalGuideLine addNewDisposalGuideline(DisposalGuideLine disposalGuideLine, Long wasteCategoryId)
    {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(wasteCategoryId)
                .orElseThrow(() -> new IllegalStateException("The waste category of Id: " +
                        wasteCategoryId + " does not exist"));

        disposalGuideLine.setWasteCategory(wasteCategory);

        DisposalGuideLine savedDisposalGuideLine = disposalGuideLineRepository.save(disposalGuideLine);

        wasteCategory.getDisposalGuideLines().add(savedDisposalGuideLine);

        return savedDisposalGuideLine;
    }

    //delete a waste disposal guideline ________________________________________________________________________________
    @Transactional
    public void deleteDisposalGuideline(Long disposalGuideLineId)
    {
        DisposalGuideLine existingGuideline = disposalGuideLineRepository.findById(disposalGuideLineId)
                .orElseThrow(()-> new IllegalStateException("GuideLine of id: "+disposalGuideLineId+
                        " could not be found"));

                existingGuideline.getWasteCategory().getDisposalGuideLines().remove(existingGuideline);

                disposalGuideLineRepository.delete(existingGuideline);
    }
    //Update a waste disposal guideline ________________________________________________________________________________

    @Transactional
    public DisposalGuideLine updateDisposalGuideline(DisposalGuideLine disposalGuideLine, Long disposalGuidelineId)
    {
        DisposalGuideLine existingGuidline = disposalGuideLineRepository.findById(disposalGuidelineId)
                .orElseThrow(()-> new IllegalStateException("Disposal guideline of id: "+disposalGuidelineId+
                        " is not found"));

        if (disposalGuideLine.getTitle() != null &&
                disposalGuideLine.getTitle().length() > 0 &&
                !Objects.equals( existingGuidline.getTitle(), disposalGuideLine.getTitle() ))
        {
            existingGuidline.setTitle(disposalGuideLine.getTitle());
        }

        if (disposalGuideLine.getBody() != null &&
                disposalGuideLine.getBody().length() > 0 &&
                !Objects.equals( existingGuidline.getBody(), disposalGuideLine.getBody() ))
        {
            existingGuidline.setBody(disposalGuideLine.getBody());
        }

        return existingGuidline;
    }


}
