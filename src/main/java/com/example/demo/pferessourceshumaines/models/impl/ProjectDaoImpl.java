package com.example.demo.pferessourceshumaines.models.impl;

import com.example.demo.pferessourceshumaines.models.dao.ProjectDao;
import com.example.demo.pferessourceshumaines.models.entity.Project;
import com.example.demo.pferessourceshumaines.models.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ProjectDaoImpl implements ProjectDao {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectDaoImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAll() {
        return this.projectRepository.findAll();
    }

    @Override
    public Project addProject(Project project) {
        try {
            return projectRepository.save(project);
        } catch (DataIntegrityViolationException ex){
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Project updateProject(Project project) {
        try {
            return projectRepository.save(project);
        } catch (DataIntegrityViolationException ex){
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Optional<Project> findProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }
}
