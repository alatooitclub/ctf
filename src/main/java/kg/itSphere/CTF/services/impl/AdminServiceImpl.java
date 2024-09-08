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
    private final CategoryRepository categoryRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public void addTask(TaskRequest taskRequest) {

        Task task = new Task();
        taskRepository.save(taskMapper.toDtoTask(task, taskRequest));
    }

    @Override
    public void updateTask(Long taskId, TaskRequest taskRequest) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isEmpty()) {
            throw new NotFoundException("task not found", HttpStatus.NOT_FOUND);
        }
        taskRepository.save(taskMapper.toDtoTask(task.get(), taskRequest));
    }

    @Override
    public void deleteTask(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isEmpty()) {
            throw new NotFoundException("task not found", HttpStatus.NOT_FOUND);
        }
        taskRepository.deleteById(taskId);
    }

    @Override
    public void addCategory(CategoryRequest categoryRequest) {
        if (categoryRequest.getCategoryName().isEmpty()) {
            throw new BadRequestException("Category name can't be empty");
        }
        Optional<Category> category = categoryRepository.findByName(categoryRequest.getCategoryName());
        if (category.isPresent()) {
            throw new BadRequestException("category with this name" + categoryRequest.getCategoryName() + " already exist!");
        }
        Category category1 = new Category();
        category1.setName(categoryRequest.getCategoryName());
        categoryRepository.save(category1);
    }

    @Override
    public void addEvent(EventRequest eventRequest) {
        if (eventRequest.getName().isEmpty()) {
            throw new BadRequestException("Event name can't be empty");
        }
        if (eventRequest.getDescription().isEmpty()) {
            throw new BadRequestException("Event description can't be empty");
        }
        if (eventRequest.getLocation().isEmpty()) {
            throw new BadRequestException("Event location can't be empty");
        }
        if (eventRequest.getFormat().isEmpty()) {
            throw new BadRequestException("Event format can't be empty");
        }
        if (eventRequest.getDateStart().getYear() < 0) {
            throw new BadRequestException("Year can't be negative");
        }
        if (eventRequest.getDateStart().getMonth() < 1 || eventRequest.getDateStart().getMonth() > 12) {
            throw new BadRequestException("Incorrect month");
        }
        if (eventRequest.getDateStart().getDay() > 31 || eventRequest.getDateStart().getDay() < 1) {
            throw new BadRequestException("Incorrect day");
        }
        if (eventRequest.getDateStart().getMonth() == 2) {
            if(isLeapYear(eventRequest.getDateStart().getYear())){
                if(eventRequest.getDateStart().getDay()>29){
                    throw new BadRequestException("Incorrect day for this month");
                }
            }
            else{
                if(eventRequest.getDateStart().getDay()>28){
                    throw new BadRequestException("Incorrect day for this month");
                }
            }
        } else if (eventRequest.getDateStart().getMonth() == 4 || eventRequest.getDateStart().getMonth() == 6 ||
                eventRequest.getDateStart().getMonth() == 9 || eventRequest.getDateStart().getMonth() == 11) {
            if (eventRequest.getDateStart().getDay() > 30) {
                throw new BadRequestException("Incorrect day for this month");
            }
        }
        if (eventRequest.getDateStart().getMinute() < 0 || eventRequest.getDateStart().getMinute() > 59) {
            throw new BadRequestException("Incorrect minute");
        }
        if (eventRequest.getDateStart().getSeconds() < 0 || eventRequest.getDateStart().getSeconds() > 59) {
            throw new BadRequestException("Incorrect seconds");
        }
        if (eventRequest.getDateStart().getHour() > 23 || eventRequest.getDateStart().getHour() < 0) {
            throw new BadRequestException("Incorrect hour(24 format)");
        }

        if (eventRequest.getDateEnd().getYear() < 0) {
            throw new BadRequestException("Year can't be negative");
        }
        if (eventRequest.getDateEnd().getMonth() < 1 || eventRequest.getDateEnd().getMonth() > 12) {
            throw new BadRequestException("Incorrect month");
        }
        if (eventRequest.getDateEnd().getDay() > 31 || eventRequest.getDateEnd().getDay() < 1) {
            throw new BadRequestException("Incorrect day");
        }
        if (eventRequest.getDateEnd().getMonth() == 2) {
            if(isLeapYear(eventRequest.getDateStart().getYear())){
                if(eventRequest.getDateEnd().getDay()>29){
                    throw new BadRequestException("Incorrect day for this month");
                }
            }
            else{
                if(eventRequest.getDateStart().getDay()>28){
                    throw new BadRequestException("Incorrect day for this month");
                }
            }
        } else if (eventRequest.getDateStart().getMonth() == 4 || eventRequest.getDateStart().getMonth() == 6 ||
                eventRequest.getDateStart().getMonth() == 9 || eventRequest.getDateStart().getMonth() == 11) {
            if (eventRequest.getDateEnd().getDay() > 30) {
                throw new BadRequestException("Incorrect day for this month");
            }
        }
        if (eventRequest.getDateEnd().getMinute() < 0 || eventRequest.getDateEnd().getMinute() > 59) {
            throw new BadRequestException("Incorrect minute");
        }
        if (eventRequest.getDateEnd().getSeconds() < 0 || eventRequest.getDateEnd().getSeconds() > 59) {
            throw new BadRequestException("Incorrect seconds");
        }
        if (eventRequest.getDateEnd().getHour() > 23 || eventRequest.getDateEnd().getHour() < 0) {
            throw new BadRequestException("Incorrect hour(24 format)");
        }
        Optional<Event> event1 = eventRepository.findByName(eventRequest.getName());
        if(event1.isPresent()){
            throw new BadRequestException("Event with this name already exist");
        }

        Event event = new Event();
        eventRepository.save(eventMapper.toDtoEvent(event, eventRequest));
    }
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
