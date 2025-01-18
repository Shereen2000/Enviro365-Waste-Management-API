package com.enviro.assessment.grad001.shereenmokautu.dto.mapper;

import com.enviro.assessment.grad001.shereenmokautu.dto.request.WasteCategoryCreateRequest;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.WasteCategoryUpdateRequest;
import com.enviro.assessment.grad001.shereenmokautu.dto.response.WasteCategoryResponse;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteCategory;
import org.springframework.stereotype.Component;

@Component
public class WasteCategoryMapper {


    public WasteCategoryResponse toWasteCategoryResponse(WasteCategory wasteCategory)
    {
        return  new WasteCategoryResponse(
                wasteCategory.getId(),
                wasteCategory.getName(),
                wasteCategory.getDescription(),
                wasteCategory.getWasteType(),
                wasteCategory.getDisposalGuideLines());
    }

    public WasteCategory toWasteCategory(WasteCategoryCreateRequest wasteCategoryCreateRequest)
    {
        return new WasteCategory(
                wasteCategoryCreateRequest.getName(),
                wasteCategoryCreateRequest.getDescription(),
                wasteCategoryCreateRequest.getWasteType()
        );
    }

    public WasteCategory toWasteCategory(WasteCategoryUpdateRequest wasteCategoryUpdateRequest)
    {
        return new WasteCategory(
                wasteCategoryUpdateRequest.getName(),
                wasteCategoryUpdateRequest.getDescription(),
                wasteCategoryUpdateRequest.getWasteType()
        );
    }



}
