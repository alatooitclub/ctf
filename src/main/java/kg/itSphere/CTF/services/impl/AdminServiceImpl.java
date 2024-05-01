package kg.itSphere.CTF.services.impl;

import kg.itSphere.CTF.dto.event.EventRequest;
import kg.itSphere.CTF.dto.task.CategoryRequest;
import kg.itSphere.CTF.dto.task.TaskRequest;
import kg.itSphere.CTF.entities.Category;
import kg.itSphere.CTF.entities.Event;
import kg.itSphere.CTF.exception.BadCredentialsException;
import kg.itSphere.CTF.exception.BadRequestException;
import kg.itSphere.CTF.exception.NotFoundException;
import kg.itSphere.CTF.entities.Task;
import kg.itSphere.CTF.mapper.EventMapper;
import kg.itSphere.CTF.mapper.TaskMapper;
import kg.itSphere.CTF.repository.CategoryRepository;
import kg.itSphere.CTF.repository.EventRepository;
import kg.itSphere.CTF.repository.ImageRepository;
import kg.itSphere.CTF.repository.TaskRepository;
import kg.itSphere.CTF.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final CategoryRepository categoryRepository    ;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    @Override
    public void addTask(TaskRequest taskRequest) {

        Task task = new Task();
        taskRepository.save(taskMapper.toDtoTask(task , taskRequest ));
    }

    @Override
    public void updateTask(Long taskId, TaskRequest taskRequest) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isEmpty()){
            throw new NotFoundException("task not found" ,HttpStatus.NOT_FOUND);
        }
        taskRepository.save(taskMapper.toDtoTask(task.get() , taskRequest));
    }

    @Override
    public void deleteTask(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isEmpty()){
            throw new NotFoundException("task not found" , HttpStatus.NOT_FOUND );
        }
        taskRepository.deleteById(taskId);
    }

    @Override
    public void addCategory(CategoryRequest categoryRequest) {
        if(categoryRequest.getCategoryName().isEmpty()){
            throw new BadRequestException("Category name can't be empty");
        }
        Optional<Category>category = categoryRepository.findByName(categoryRequest.getCategoryName());
        if(category.isPresent()){
            throw new BadRequestException("category with this name"+categoryRequest.getCategoryName() +" already exist!");
        }
        Category category1 = new Category();
        category1.setName(categoryRequest.getCategoryName());
        categoryRepository.save(category1);
    }

    @Override
    public void addEvent(EventRequest eventRequest) {
        Event event = new Event();
        eventRepository.save(eventMapper.toDtoEvent(event, eventRequest));
    }

}
