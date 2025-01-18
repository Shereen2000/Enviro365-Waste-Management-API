package com.enviro.assessment.grad001.shereenmokautu.dto.request;

import jakarta.validation.constraints.NotNull;
public class WasteProductSortRequest {

    @NotNull(message = "Waste Product ID cannot be null")
    private Long wasteProductId;

    @NotNull(message = "Waste Category ID cannot be null")
    private Long wasteCategoryId;

    public Long getWasteProductId() {
        return wasteProductId;
    }

    public Long getWasteCategoryId() {
        return wasteCategoryId;
    }

}
