package com.enviro.assessment.grad001.shereenmokautu.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DisposalGuidelineUpdateRequest {

    private String title;

    private String body;

    public  String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

}
