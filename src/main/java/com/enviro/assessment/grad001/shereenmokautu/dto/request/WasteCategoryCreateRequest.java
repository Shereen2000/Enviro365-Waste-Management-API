package com.enviro.assessment.grad001.shereenmokautu.dto.request;

import com.enviro.assessment.grad001.shereenmokautu.enums.WasteType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
public class WasteCategoryCreateRequest {


    private String name;
    @NotBlank(message = "Category name cannot be blank or null")
    @Size(min = 1, max = 30, message = "Product name must be between 1 a 30 characters")

    @NotBlank(message = "Category description cannot be blank or null")
    @Size(min = 1, max = 100, message = "Category description must be between 1 a 100 characters")
    private String description;

    @NotNull(message = "Waste type cannot be null")
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
