package kg.itSphere.CTF.mapper;

import kg.itSphere.CTF.dto.task.TaskResponse;
import kg.itSphere.CTF.entities.Task;

import java.util.List;

public interface TaskMapper {
    TaskResponse toDto(Task task);
    List<TaskResponse> toDtos(List<Task> tasks);
}
