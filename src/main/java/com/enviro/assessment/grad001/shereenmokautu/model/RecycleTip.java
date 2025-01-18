package com.enviro.assessment.grad001.shereenmokautu.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class RecycleTip {

    @Id
    @SequenceGenerator(
            name = "recycleTip_sequence",
            sequenceName = "recycleTip_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recycleTip_sequence"
    )
    private Long id;

    private String title;

    private String body;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    private Boolean isActive;

    public RecycleTip() {
    }

    public RecycleTip(Long id, String title, String body, LocalDate createdAt, LocalDate updateAt, Boolean isActive) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.createdAt = createdAt;
        this.updatedAt = updateAt;
        this.isActive = isActive;
    }


    public RecycleTip(String title, String body, Boolean isActive) {
        this.title = title;
        this.body = body;
        this.updatedAt = LocalDate.now();
        this.createdAt = LocalDate.now();
        this.isActive = isActive;
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

    public void setTitle(String title) {
        this.title = title;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
