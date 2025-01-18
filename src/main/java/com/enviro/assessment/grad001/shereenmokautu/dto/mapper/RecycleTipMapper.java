package com.enviro.assessment.grad001.shereenmokautu.dto.mapper;

import com.enviro.assessment.grad001.shereenmokautu.dto.request.RecycleTipCreateRequest;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.RecycleTipUpdateRequest;
import com.enviro.assessment.grad001.shereenmokautu.model.RecycleTip;
import org.springframework.stereotype.Component;

@Component
public class RecycleTipMapper {

    public RecycleTip toRecycleTip(RecycleTipCreateRequest recycleTipCreateRequest)
    {
        return new RecycleTip(
                recycleTipCreateRequest.getTitle(),
                recycleTipCreateRequest.getBody(),
                recycleTipCreateRequest.getIsActive()
        );

    }

    public RecycleTip toRecycleTip(RecycleTipUpdateRequest recycleTipUpdateRequest)
    {
        return new RecycleTip(
                recycleTipUpdateRequest.getTitle(),
                recycleTipUpdateRequest.getBody(),
                recycleTipUpdateRequest.getIsActive()
        );
    }
}
