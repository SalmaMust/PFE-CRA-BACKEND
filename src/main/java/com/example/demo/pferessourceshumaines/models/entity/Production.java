package com.example.demo.pferessourceshumaines.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
public class Production {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Date date;

    @NotBlank
    private String duration ;

    @ManyToOne
    private Timesheet timesheet;

    @ManyToOne
    private Task tache;

    public Production(){
    }

    public Production(@NotBlank Date date, @NotBlank String duration) {
        this.date = date;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }

    public Task getTache() {
        return tache;
    }

    public void setTache(Task tache) {
        this.tache = tache;
    }
}
