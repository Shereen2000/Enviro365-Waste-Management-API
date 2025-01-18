package com.enviro.assessment.grad001.shereenmokautu.enums;

public enum WasteType {

    H("Hazardous Waste"),
    NH("Non-Hazardous Waste");

    private final String description;

    // Constructor to associate each enum constant with a description
    WasteType(String description) {
        this.description = description;
    }

    // Getter method to access the description
    public String getDescription() {
        return description;
    }
}
