package kg.itSphere.CTF.mapper.impl;

import kg.itSphere.CTF.dto.task.TaskRequest;
import kg.itSphere.CTF.dto.task.TaskResponse;
import kg.itSphere.CTF.entities.Category;
import kg.itSphere.CTF.entities.Image;
import kg.itSphere.CTF.entities.Task;
import kg.itSphere.CTF.enums.TaskStatus;
import kg.itSphere.CTF.exception.NotFoundException;
import kg.itSphere.CTF.mapper.TaskMapper;
import kg.itSphere.CTF.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TaskMapperImpl implements TaskMapper {
    private final CategoryRepository categoryRepository;
    @Override
    public TaskResponse toDto(Task task) {
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setName(task.getName());
        taskResponse.setStatus(TaskStatus.ACTIVE.name());
        taskResponse.setCategory(task.getCategory().getName());
        return taskResponse;
    }

    @Override
    public List<TaskResponse> toDtos(List<Task> tasks) {
        List<TaskResponse> taskResponse =new ArrayList<>();
        for(Task task : tasks){
        taskResponse.add(toDto(task));
        }
        return taskResponse;
    }

    @Override
    public Task toDtoTask(Task task, TaskRequest taskRequest) {
        Optional<Category> category=categoryRepository.findByName(taskRequest.getCategory());
        if(category.isEmpty()){
            throw new NotFoundException("Category with this name " +taskRequest.getCategory()+" wasn't found " , HttpStatus.NOT_FOUND);
        }

        task.setCategory(category.get());
        task.setFlag(taskRequest.getFlag());
        task.setDescription(taskRequest.getDescription());
        task.setName(taskRequest.getName());
        task.setPoints(taskRequest.getPoints());
        task.setStatus(TaskStatus.ACTIVE);
        return task;



    }
}
