package com.enviro.assessment.grad001.shereenmokautu.dto.mapper;

import com.enviro.assessment.grad001.shereenmokautu.dto.request.WasteProductRequest;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.WasteProductSortRequest;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteProduct;
import com.enviro.assessment.grad001.shereenmokautu.model.WasteSortingAnswer;
import org.springframework.stereotype.Component;

@Component
public class WasteProductMapper {

    public WasteSortingAnswer toWasteSortingAnswer(WasteProductSortRequest wasteProductSortRequest)
    {
        return new WasteSortingAnswer(
                wasteProductSortRequest.getWasteProductId(),
                wasteProductSortRequest.getWasteCategoryId()
        );
    }

    public WasteProduct toWasteProduct(WasteProductRequest wasteProductRequest)
    {
        return new WasteProduct(
               wasteProductRequest.getName()
        );
    }
}
