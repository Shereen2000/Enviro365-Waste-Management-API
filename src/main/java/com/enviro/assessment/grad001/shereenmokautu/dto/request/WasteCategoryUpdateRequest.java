package com.enviro.assessment.grad001.shereenmokautu.dto.request;

import com.enviro.assessment.grad001.shereenmokautu.enums.WasteType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class WasteCategoryUpdateRequest {

    private String name;
    private String description;
    private WasteType wasteType;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public WasteType getWasteType() {
        return wasteType;
    }
}
