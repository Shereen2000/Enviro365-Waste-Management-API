package com.enviro.assessment.grad001.shereenmokautu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class WasteProductRequest {

    @NotBlank(message = "Product name cannot be blank or null")
    @Size(min = 1, max = 30, message = "Product name must be between 1 a 30 characters")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
