package kg.itSphere.CTF.services;

import kg.itSphere.CTF.dto.task.TaskDetailResponse;
import kg.itSphere.CTF.dto.task.TaskResponse;

import java.util.List;

public interface TaskService {
    List<TaskResponse> all();
    TaskDetailResponse detail(Long id);
}
