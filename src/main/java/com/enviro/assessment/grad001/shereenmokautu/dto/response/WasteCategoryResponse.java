package com.enviro.assessment.grad001.shereenmokautu.dto.response;

import com.enviro.assessment.grad001.shereenmokautu.enums.WasteType;
import com.enviro.assessment.grad001.shereenmokautu.model.DisposalGuideLine;
import java.util.Set;

public class WasteCategoryResponse {

    private long id;

    private String name;

    private String description;

    private String wasteType;

    private Set<DisposalGuideLine> disposalGuideLines;

    public WasteCategoryResponse() {
    }

    public WasteCategoryResponse(Long id, String name, String description, WasteType wasteType, Set<DisposalGuideLine> disposalGuideLines) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.wasteType = wasteType.getDescription();
        this.disposalGuideLines = disposalGuideLines;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setDisposalGuideLines(Set<DisposalGuideLine> disposalGuideLines) {
        this.disposalGuideLines = disposalGuideLines;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public Set<DisposalGuideLine> getDisposalGuideLines() {
        return disposalGuideLines;
    }
}
