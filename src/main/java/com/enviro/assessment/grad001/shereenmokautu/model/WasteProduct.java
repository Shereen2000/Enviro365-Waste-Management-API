package com.enviro.assessment.grad001.shereenmokautu.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table
public class WasteProduct {
    @Id
    @SequenceGenerator(
            name = "wasteProduct_sequence",
            sequenceName = "wasteProduct_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wasteProduct_sequence"
    )
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name="waste_category_Id"
    )
    private WasteCategory wasteCategory;

    public WasteProduct() {
    }

    public WasteProduct(String name, WasteCategory wasteCategory) {
        this.name = name;
        this.wasteCategory = wasteCategory;
    }

    public WasteProduct(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WasteCategory getWasteCategory() {
        return wasteCategory;
    }

    public void setWasteCategory(WasteCategory wasteCategory) {
        this.wasteCategory = wasteCategory;
    }
}



