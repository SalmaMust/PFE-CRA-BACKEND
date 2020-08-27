package com.example.demo.pferessourceshumaines.controllers;

import com.example.demo.pferessourceshumaines.models.entity.Task;

import com.example.demo.pferessourceshumaines.models.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin("*")
@RequestMapping("/api")
public class TaskController {
    @Autowired

    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/task")
    public Task createTask(@Valid @RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long taskId,
                                               @Valid @RequestBody Task taskDetails) throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("task not found for this id :: " + taskId));

        task.setTaskName(taskDetails.getTaskName());
        task.setDate(taskDetails.getDate());
        task.setStatus(taskDetails.getStatus());
        task.setPriorite(taskDetails.getPriorite());
        task.setDescription(taskDetails.getDescription());


        final Task updatedTask = taskRepository.save(task);
        return ResponseEntity.ok(updatedTask);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable(value = "id") Long taskId)
            throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("task not found for this id :: " + taskId));
        return ResponseEntity.ok().body(task);
    }

    @DeleteMapping("/tasks/{id}")
    public Map<String, Boolean> deleteTask(@PathVariable(value = "id") Long taskId)
            throws ResourceNotFoundException {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("task not found for this id :: " + taskId));

        taskRepository.delete(task);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    @GetMapping("/{id}/usertasks")
    public ResponseEntity<List<Task>> getTaskByUserId(@PathVariable(value = "id") Long userId) {
        List<Task> tasks = taskRepository.getTaskByUserId(userId);
        // .orElseThrow(() -> new ResourceNotFoundException("task not found for this id :: " + userId));
        return ResponseEntity.ok().body(tasks);
    }
}














