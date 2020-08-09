package com.example.demo.pferessourceshumaines.services.impl;

import com.example.demo.pferessourceshumaines.models.dao.ProjectDao;
import com.example.demo.pferessourceshumaines.models.entity.Project;
import com.example.demo.pferessourceshumaines.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Override
    public List<Project> getAll(){
        return projectDao.getAll();
    }

    @Override
    public Project addProject(Project project) {
        return projectDao.addProject(project);
    }

    @Override
    public Project updateProject(Project project) {
        return projectDao.updateProject(project);
    }

    @Override
    public Optional<Project> findProjectById(Long projectId) {
        return projectDao.findProjectById(projectId);
    }
}
