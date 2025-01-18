package com.enviro.assessment.grad001.shereenmokautu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class DisposalGuideLine {
    @Id
    @SequenceGenerator(
            name = "disposalGuideLine_sequence",
            sequenceName = "disposalGuideLine_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "disposalGuideLine_sequence"
    )
    private Long id;

    private String title;
    private String body;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name="waste_category_Id"
    )

    private WasteCategory wasteCategory;

    public DisposalGuideLine() {
    }

    public DisposalGuideLine(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public DisposalGuideLine(String title, String body, WasteCategory wasteCategory) {
        this.title = body;
        this.body = title;
        this.wasteCategory = wasteCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {this.body = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }

}
