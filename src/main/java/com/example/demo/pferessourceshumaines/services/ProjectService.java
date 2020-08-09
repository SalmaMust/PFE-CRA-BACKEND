package com.example.demo.pferessourceshumaines.services;

import com.example.demo.pferessourceshumaines.models.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project> getAll();

    Project addProject ( Project project);

    Project updateProject( Project project);

    Optional<Project> findProjectById(Long projectId);
}
