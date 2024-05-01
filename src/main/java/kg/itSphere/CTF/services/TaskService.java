package kg.itSphere.CTF.services;

import kg.itSphere.CTF.dto.task.TaskDetailResponse;
import kg.itSphere.CTF.dto.task.TaskResponse;
import kg.itSphere.CTF.entities.Task;

import java.util.List;

public interface TaskService {
    List<TaskResponse> all();
    TaskDetailResponse detail(Long id);

    List<Task> getAllTasks();
//    List<TaskResponse> findTasksByCategory(String category);
//    List<TaskResponse> findTasksByName(String name);
//    List<TaskResponse> findTasksByCategoryAndName(String category, String name);
}
