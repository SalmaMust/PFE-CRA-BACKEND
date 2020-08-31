package com.example.demo.pferessourceshumaines.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Entity
public class Timesheet {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private int month;

    @NotBlank
    private int year;

    @NotBlank
    private Date creationDate;

    @NotBlank
    private String validation ;

    @NotBlank
    private String nameValidator;

    @NotBlank
    private String detailValidation;

    @NotBlank
    private Long totalProduction;

    @NotBlank
    private Long totalIntern;
    @NotBlank
    private int totalAbsence;

    private String Status;

    @OneToMany
    private List<Production> productionList;

    @OneToMany
    private List<Internal> interneList;

    @ManyToOne
    private User user;

    public Timesheet(){

    }

    public Timesheet(@NotBlank int month, @NotBlank int year, @NotBlank Date creationDate, @NotBlank String validation, @NotBlank String nameValidator, @NotBlank String detailValidation, @NotBlank Long totalProduction, @NotBlank int totalAbsence) {
        this.month = month;
        this.year = year;
        this.creationDate = creationDate;
        this.validation = validation;
        this.nameValidator = nameValidator;
        this.detailValidation = detailValidation;
        this.totalProduction = totalProduction;
        this.totalAbsence = totalAbsence;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public String getNameValidator() {
        return nameValidator;
    }

    public void setNameValidator(String nameValidator) {
        this.nameValidator = nameValidator;
    }

    public String getDetailValidation() {
        return detailValidation;
    }

    public void setDetailValidation(String detailValidation) {
        this.detailValidation = detailValidation;
    }

    public Long getTotalProduction() {
        return totalProduction;
    }

    public void setTotalProduction(Long totalProduction) {
        this.totalProduction = totalProduction;
    }

    public int getTotalAbsence() {
        return totalAbsence;
    }

    public void setTotalAbsence(int totalAbsence) {
        this.totalAbsence = totalAbsence;
    }

    public List<Production> getProductionList() {
        return productionList;
    }

    public List<Internal> getInterneList() {
        return interneList;
    }

    public void setProductionList(List<Production> productionList) {
        this.productionList = productionList;
    }

    public void setInterneList(List<Internal> interneList) {
        this.interneList = interneList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getTotalIntern() {
        return totalIntern;
    }

    public void setTotalIntern(Long totalIntern) {
        this.totalIntern = totalIntern;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}

