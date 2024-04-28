package kg.itSphere.CTF.services.impl;

import kg.itSphere.CTF.dto.task.TaskDetailResponse;
import kg.itSphere.CTF.dto.task.TaskResponse;
import kg.itSphere.CTF.entities.Task;
import kg.itSphere.CTF.mapper.TaskMapper;
import kg.itSphere.CTF.repository.TaskRepository;
import kg.itSphere.CTF.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private TaskMapper taskMapper;
    private TaskRepository repository;
    @Override
    public List<TaskResponse> all() {
        return taskMapper.toDtos(repository.findAll());
    }

    @Override
    public TaskDetailResponse detail(Long id) {
        Optional<Task>ctf = repository.findById(id);

        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

}
