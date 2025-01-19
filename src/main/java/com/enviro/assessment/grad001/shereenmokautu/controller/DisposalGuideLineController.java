package com.enviro.assessment.grad001.shereenmokautu.controller;

import com.enviro.assessment.grad001.shereenmokautu.dto.mapper.DisposalGuidelineMapper;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.DisposalGuidelineCreateRequest;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.DisposalGuidelineUpdateRequest;
import com.enviro.assessment.grad001.shereenmokautu.model.DisposalGuideLine;
import com.enviro.assessment.grad001.shereenmokautu.service.DisposalGuideLineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/disposal-guidelines")
public class DisposalGuideLineController {

    private DisposalGuideLineService disposalGuideLineService;
    private DisposalGuidelineMapper disposalGuidelineMapper;

    @Autowired
    public DisposalGuideLineController(
            DisposalGuideLineService disposalGuideLineService,
            DisposalGuidelineMapper disposalGuidelineMapper)
    {
        this.disposalGuideLineService = disposalGuideLineService;
        this.disposalGuidelineMapper = disposalGuidelineMapper;
    }

    @PostMapping(path = "/waste-categories/{wasteCategory_Id}")
    public DisposalGuideLine addNewDisposalGuideline(@RequestBody @Valid DisposalGuidelineCreateRequest disposalGuidelineCreateRequest,
                                                     @PathVariable Long wasteCategory_Id)
    {
        return disposalGuideLineService.addNewDisposalGuideline(disposalGuidelineMapper
                .toDisposalGuideline(disposalGuidelineCreateRequest), wasteCategory_Id);
    }

    @GetMapping
    public List<DisposalGuideLine> getAllDisposalGuidelines()
    {
        return disposalGuideLineService.getAllDisposalGuidelines();
    }

    @GetMapping(path = {"/{disposalGuideline_Id}"})
    public DisposalGuideLine getDisposalGuidelineById(@PathVariable Long disposalGuideline_Id)
    {
        return disposalGuideLineService.getDisposalGuidelineById(disposalGuideline_Id);
    }

    @GetMapping(path = {"/waste-categories/{wasteCategory_Id}"})
    public List<DisposalGuideLine> getDisposalGuideline_ByWasteCategoryId(@PathVariable Long wasteCategory_Id)
    {
        return disposalGuideLineService.getByWasteCategory(wasteCategory_Id);
    }

    @DeleteMapping(path = "/{disposalGuideline_Id}")
    public void deleteDisposalGuideline(@PathVariable Long disposalGuideline_Id)
    {
        disposalGuideLineService.deleteDisposalGuideline(disposalGuideline_Id);
    }

    @PutMapping(path = "/{guideline_id}")
    public DisposalGuideLine updateDisposalGuideline(@RequestBody @Valid DisposalGuidelineUpdateRequest disposalGuidelineUpdateRequest,
                                                     Long guideline_id)
    {

        return disposalGuideLineService.updateDisposalGuideline(disposalGuidelineMapper
                .toDisposalGuideline(disposalGuidelineUpdateRequest),guideline_id);
    }

}
