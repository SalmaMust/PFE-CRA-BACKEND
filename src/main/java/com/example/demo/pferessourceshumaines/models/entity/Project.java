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
    private String type;
    private String status;
    private String priorite;
    @ManyToOne
    private User responsable;

    @ManyToOne
    private Client client;

    public User getResponsable() {
        return responsable;
    }

    public void setResponsable(User responsable) {
        this.responsable = responsable;
    }



    public Project() {
    }

    public Project(String projectName, String description, Date dateDebut, Date dateFin, String type, String status, String priorite, Client client) {
        this.projectName = projectName;
        this.description = description;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.type = type;
        this.status = status;
        this.priorite = priorite;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriorite() {
        return priorite;
    }

    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
