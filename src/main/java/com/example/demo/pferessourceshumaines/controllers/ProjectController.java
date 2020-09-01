package com.example.demo.pferessourceshumaines.controllers;


import com.example.demo.pferessourceshumaines.models.entity.Project;
import com.example.demo.pferessourceshumaines.models.repository.ProjectRepository;
import com.example.demo.pferessourceshumaines.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController @CrossOrigin("*")
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @PostMapping("/project")
    public Project createProject(@Valid @RequestBody Project project) {
        return projectRepository.save(project);
    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable(value = "id") Long projectId,
                                                   @Valid @RequestBody Project projectDetails) throws ResourceNotFoundException {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

        project.setProjectName(projectDetails.getProjectName());
        project.setDescription(projectDetails.getDescription());
        project.setDateDebut(projectDetails.getDateDebut());
        project.setDateFin(projectDetails.getDateFin());
        project.setStatus(projectDetails.getStatus());
        project.setType(projectDetails.getType());
        project.setPriorite(projectDetails.getPriorite());
        final Project updatedProject = projectRepository.save(project);
        return ResponseEntity.ok(updatedProject);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable(value = "id") Long projectId)
            throws ResourceNotFoundException {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));
        return ResponseEntity.ok().body(project);
    }

    @DeleteMapping("/projects/{id}")
    public Map<String, Boolean> deleteProject(@PathVariable(value = "id") Long projectId)
            throws ResourceNotFoundException {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found for this id :: " + projectId));

        projectRepository.delete(project);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
   // @GetMapping("/bymanager/{id}")
    //public List<Project> getProjectsByManagerId(@PathVariable(value = "id") Long managerId) {
       // return projectRepository.findAllByManagerId(managerId
     //   );
    //}
}










