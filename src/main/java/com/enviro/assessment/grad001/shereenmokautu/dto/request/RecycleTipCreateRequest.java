package com.enviro.assessment.grad001.shereenmokautu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RecycleTipCreateRequest {
    @NotBlank(message = "Title cannot be blank or null")
    @Size(min = 1, max = 30, message = "Title must be between 1 a 30 characters")
    private String title;

    @NotBlank(message = "Body cannot be blank or null")
    @Size(min = 10, max = 100, message = "Body must be between 10 and 100 characters")
    private String body;

    @NotNull(message = "isActive cannot be null")
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
