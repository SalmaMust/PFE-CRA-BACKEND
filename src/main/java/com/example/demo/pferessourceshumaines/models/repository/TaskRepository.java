package com.example.demo.pferessourceshumaines.models.repository;

import com.example.demo.pferessourceshumaines.models.entity.Project;
import com.example.demo.pferessourceshumaines.models.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByTaskName(String taskName);
    Boolean existsByTaskName (String taskName);

}
