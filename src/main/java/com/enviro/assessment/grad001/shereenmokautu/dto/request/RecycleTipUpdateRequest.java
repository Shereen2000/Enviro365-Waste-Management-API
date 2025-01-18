package com.enviro.assessment.grad001.shereenmokautu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RecycleTipUpdateRequest {

    private String title;

    private String body;

    private Boolean isActive;

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public Boolean getIsActive() {
        return isActive;
    }
}
