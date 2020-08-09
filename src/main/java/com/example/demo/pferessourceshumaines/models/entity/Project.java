package com.example.demo.pferessourceshumaines.models.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Project {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String projectName;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    private Client client;

    public Project() {
    }

    public Project(String projectName, String description, Date dateDebut, Date dateFin, Client client) {
        this.projectName = projectName;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
