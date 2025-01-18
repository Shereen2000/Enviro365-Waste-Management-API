package com.enviro.assessment.grad001.shereenmokautu.dto.mapper;

import com.enviro.assessment.grad001.shereenmokautu.dto.request.DisposalGuidelineCreateRequest;
import com.enviro.assessment.grad001.shereenmokautu.dto.request.DisposalGuidelineUpdateRequest;
import com.enviro.assessment.grad001.shereenmokautu.model.DisposalGuideLine;
import org.springframework.stereotype.Component;

@Component
public class DisposalGuidelineMapper {

    public DisposalGuideLine toDisposalGuideline(DisposalGuidelineCreateRequest disposalGuidelineCreateRequest)
    {
        return new DisposalGuideLine(
                disposalGuidelineCreateRequest.getTitle(),
                disposalGuidelineCreateRequest.getBody()

        );
    }
    public DisposalGuideLine toDisposalGuideline(DisposalGuidelineUpdateRequest disposalGuidelineUpdateRequest)
    {
        return new DisposalGuideLine(
                disposalGuidelineUpdateRequest.getTitle(),
                disposalGuidelineUpdateRequest.getBody()

        );
    }

}
