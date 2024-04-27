package kg.itSphere.CTF.mapper.impl;

import kg.itSphere.CTF.dto.task.TaskResponse;
import kg.itSphere.CTF.entities.Task;
import kg.itSphere.CTF.mapper.TaskMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class TaskMapperImpl implements TaskMapper {
    @Override
    public TaskResponse toDto(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        if(task.getImage()!=null)
            taskResponse.setImagePath(task.getImage().getPath());
        taskResponse.setAuthor(task.getAuthor());
        taskResponse.setName(task.getName());
        taskResponse.setStatus(task.getStatus());
        taskResponse.setCategory(task.getCategory());
        return taskResponse;
    }

    @Override
    public List<TaskResponse> toDtos(List<Task> tasks) {
        List<TaskResponse> taskRespons =new ArrayList<>();
        for(Task task : tasks){
        taskRespons.add(toDto(task));
        }
        return taskRespons;
    }
}
