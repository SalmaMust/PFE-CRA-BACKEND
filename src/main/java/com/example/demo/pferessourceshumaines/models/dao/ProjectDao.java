package com.example.demo.pferessourceshumaines.models.dao;

import com.example.demo.pferessourceshumaines.models.entity.Project;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Optional;

public interface ProjectDao {

    List<Project> getAll ();

    Project addProject (Project project);

    Project updateProject (Project project);

    Optional<Project> findProjectById (Long projectId);
}
