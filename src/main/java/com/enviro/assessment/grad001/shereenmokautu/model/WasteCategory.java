package com.enviro.assessment.grad001.shereenmokautu.model;

import com.enviro.assessment.grad001.shereenmokautu.enums.WasteType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class WasteCategory {
    @Id
    @SequenceGenerator(
            name = "wasteCategory_sequence",
            sequenceName = "wasteCategory_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wasteCategory_sequence"
    )

    private Long id;

    private String name;

    private String description;

    private WasteType wasteType;

    @JsonIgnore
    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DisposalGuideLine> disposalGuideLines = new HashSet<>();


    @JsonIgnore
    @OneToMany(mappedBy = "wasteCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<WasteProduct> wasteProducts = new HashSet<>();

    public WasteCategory() {
    }

    public WasteCategory(Long id, String name, String description, WasteType wasteType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.wasteType = wasteType;
    }

    public WasteCategory(String name, String description, WasteType wasteType) {
        this.name = name;
        this.description = description;
        this.wasteType = wasteType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public WasteType getWasteType() {
        return wasteType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWasteType(WasteType wasteType) {
        this.wasteType = wasteType;
    }

    public Set<DisposalGuideLine> getDisposalGuideLines() {
        return disposalGuideLines;
    }

    public void setDisposalGuideLines(Set<DisposalGuideLine> disposalGuideLines) {
        this.disposalGuideLines = disposalGuideLines;
    }

    public Set<WasteProduct> getWasteProducts() {
        return wasteProducts;
    }

    public void setWasteProducts(Set<WasteProduct> wasteProducts) {
        this.wasteProducts = wasteProducts;
    }

}
