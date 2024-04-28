package kg.itSphere.CTF.services;

import kg.itSphere.CTF.dto.task.TaskRequest;

public interface AdminService {
    void addTask(TaskRequest taskRequest );

    void updateTask(Long taskId, TaskRequest taskRequest);

    void deleteTask(Long taskId);
}
