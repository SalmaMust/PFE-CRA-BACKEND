package com.example.demo.pferessourceshumaines.services;


import com.example.demo.pferessourceshumaines.models.entity.Task;

        import java.util.List;
        import java.util.Optional;


public interface TaskService {

    Task addTask (Task task);

    Task updateTask (Task task);

    Optional<Task> findTaskById(Long taskId);

    List<Task> getAll();
}
