package kg.itSphere.CTF.services.impl;

import kg.itSphere.CTF.dto.task.TaskDetailResponse;
import kg.itSphere.CTF.dto.task.TaskResponse;
import kg.itSphere.CTF.entities.Category;
import kg.itSphere.CTF.entities.Task;
import kg.itSphere.CTF.exception.NotFoundException;
import kg.itSphere.CTF.mapper.TaskMapper;
import kg.itSphere.CTF.repository.TaskRepository;
import kg.itSphere.CTF.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

//    @Override
//    public List<TaskResponse> findTasksByCategory(String category) {
//        List<Task> tasks = repository.findAllByCategory(category);
//        if(tasks.isEmpty()){
//            throw new NotFoundException("Found nothing", HttpStatus.NOT_FOUND);
//        }
//        else {
//            return taskMapper.toDtos(tasks);
//        }
//    }
//
//    @Override
//    public List<TaskResponse> findTasksByName(String name) {
//        List<Task> tasks = new ArrayList<>();
//        for(Task task : repository.findAll()) {
//            if(task.getName().startsWith(name)) {
//                tasks.add(task);
//            }
//        }
//        if(tasks.isEmpty()) {
//            throw new NotFoundException("Found nothing", HttpStatus.NOT_FOUND);
//        } else {
//            return taskMapper.toDtos(tasks);
//        }
//
//    }
//
//    @Override
//    public List<TaskResponse> findTasksByCategoryAndName(String category, String name) {
//        List<Task> tasks = new ArrayList<>();
//        for(Task task : repository.findAll()) {
//            if(task.getName().startsWith(name) && task.getCategory().equals(category)) {
//                tasks.add(task);
//            }
//        }
//        if(tasks.isEmpty()) {
//            throw new NotFoundException("Found nothing", HttpStatus.NOT_FOUND);
//        } else {
//            return taskMapper.toDtos(tasks);
//        }
//    }

}
