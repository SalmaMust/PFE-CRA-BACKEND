package com.example.demo.pferessourceshumaines.models.repository;

import com.example.demo.pferessourceshumaines.models.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository <Project , Long> {
    Optional<Project> findByProjectName(String projectName);
    Boolean existsByProjectName (String projectName);
}
