package com.example.demo.pferessourceshumaines.models.impl;

import com.example.demo.pferessourceshumaines.models.dao.TaskDao;
import com.example.demo.pferessourceshumaines.models.entity.Task;
import com.example.demo.pferessourceshumaines.models.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskDaoImpl  implements TaskDao {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskDaoImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public Task addTask(Task task) {
        try {
            return taskRepository.save(task);
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Task updateTask(Task task) {
        try {
            return taskRepository.save(task);
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException((ex.getMessage()));
        }
    }

    @Override
    public Optional<Task> findTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    @Override
    public List<Task> getAll() {
        try {
            return taskRepository.findAll();
        } catch (DataIntegrityViolationException ex) {
            throw new RuntimeException((ex.getMessage()));
        }
    }

}