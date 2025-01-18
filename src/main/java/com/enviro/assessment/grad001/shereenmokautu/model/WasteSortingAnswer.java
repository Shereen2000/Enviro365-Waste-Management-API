package com.enviro.assessment.grad001.shereenmokautu.model;

import com.enviro.assessment.grad001.shereenmokautu.enums.SortingResult;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

public class WasteSortingAnswer {

    @Id
    @SequenceGenerator(
            name = "answer_sequence",
            sequenceName = "answer_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "answer_sequence"
    )

    private Long id;
    private long WasteProductId;
    private String ProductName;
    private long WasteCategoryId;
    private String CategoryName;
    private SortingResult sortingResult;

    public WasteSortingAnswer() {
    }

    public WasteSortingAnswer(long wasteProductId, long wasteCategoryId) {
        WasteProductId = wasteProductId;
        WasteCategoryId = wasteCategoryId;
    }

    public WasteSortingAnswer(Long id, long wasteProductId, String productName, long wasteCategoryId, String categoryName,
                              SortingResult sortingResult) {
        this.id = id;
        WasteProductId = wasteProductId;
        ProductName = productName;
        WasteCategoryId = wasteCategoryId;
        CategoryName = categoryName;
        this.sortingResult = sortingResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getWasteProductId() {
        return WasteProductId;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public long getWasteCategoryId() {
        return WasteCategoryId;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public void setSortingResult(SortingResult sortingResult) {
        this.sortingResult = sortingResult;
    }
}
