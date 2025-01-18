package com.enviro.assessment.grad001.shereenmokautu.controller;

import com.enviro.assessment.grad001.shereenmokautu.dto.mapper.WasteCategoryMapper;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.WasteCategoryCreateRequest;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.WasteCategoryUpdateRequest;
import com.enviro.assessment.grad001.shereenmokautu.dto.response.WasteCategoryResponse;
import com.enviro.assessment.grad001.shereenmokautu.service.WasteCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "api/v1/categories")
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;
    private final WasteCategoryMapper wasteCategoryMapper;

    @Autowired
    public WasteCategoryController(WasteCategoryService wasteCategoryService, WasteCategoryMapper wasteCategoryMapper) {
        this.wasteCategoryService = wasteCategoryService;
        this.wasteCategoryMapper = wasteCategoryMapper;
    }

    @GetMapping
    public List<WasteCategoryResponse> getAll()
    {
        return wasteCategoryService.getAllWasteCategories()
                .stream()
                .map(wasteCategoryMapper::toWasteCategoryResponse)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{wasteCategory_Id}")
    public WasteCategoryResponse getById(@PathVariable Long wasteCategory_Id)
    {
        return wasteCategoryMapper.toWasteCategoryResponse(wasteCategoryService.getWasteCategoryById(wasteCategory_Id));
    }

    @DeleteMapping(path = "/{wasteCategory_Id}")
    public void delete(@PathVariable Long wasteCategory_Id)
    {
        wasteCategoryService.deleteWasteCategory(wasteCategory_Id);
    }


    @PostMapping
    public WasteCategoryResponse createNewWasteCategory(@Valid @RequestBody WasteCategoryCreateRequest wasteCategory)
    {
       return wasteCategoryMapper.toWasteCategoryResponse( wasteCategoryService.addNewWasteCategory
               (wasteCategoryMapper.toWasteCategory(wasteCategory)));

    }

    @PutMapping(path = "/{wasteCategory_id}")
    public WasteCategoryResponse updateWasteCategory(@Valid @RequestBody WasteCategoryUpdateRequest wasteCategoryUpdateRequest,
                                                     @PathVariable Long wasteCategory_id)
    {
       return wasteCategoryMapper.toWasteCategoryResponse(wasteCategoryService.updateWasteCategory
                (wasteCategoryMapper.toWasteCategory(wasteCategoryUpdateRequest),wasteCategory_id));

    }

}
