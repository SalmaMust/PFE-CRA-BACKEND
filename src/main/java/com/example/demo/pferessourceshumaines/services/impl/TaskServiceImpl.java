package com.example.demo.pferessourceshumaines.services.impl;


import com.example.demo.pferessourceshumaines.models.dao.TaskDao;
import com.example.demo.pferessourceshumaines.models.entity.Task;
import com.example.demo.pferessourceshumaines.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;
        import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;

    @Autowired
    public TaskServiceImpl(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    public Task addTask(Task task) {
        return taskDao.addTask(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskDao.updateTask(task);
    }

    @Override
    public Optional<Task> findTaskById(Long taskId) {
        return taskDao.findTaskById(taskId);
    }

    @Override
    public List<Task> getAll(){
        return taskDao.getAll();
    }
}