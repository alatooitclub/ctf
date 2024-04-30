package kg.itSphere.CTF.controller;

import kg.itSphere.CTF.dto.task.CategoryRequest;
import kg.itSphere.CTF.dto.task.TaskDetailResponse;
import kg.itSphere.CTF.dto.task.TaskResponse;
import kg.itSphere.CTF.entities.Category;
import kg.itSphere.CTF.entities.Task;
import kg.itSphere.CTF.repository.CategoryRepository;
import kg.itSphere.CTF.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final CategoryRepository repository;
    @GetMapping("")
    public String getAllTasks(Model model){
        List<Task> tasks  = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }
    @GetMapping("/all")
    public List<TaskResponse>all(){
            return taskService.all();

    }
    @GetMapping("/{id}")
    public TaskDetailResponse detailResponse(@PathVariable Long id ){
            return taskService.detail(id);
    }

    @GetMapping("/searchTasks/")
    public List<TaskResponse>findTasks(
            @RequestParam(required = false)String category ,
            @RequestParam(required = false)String name
    ){
        if((category == null || category.trim().isEmpty() || category.equals(String.valueOf(repository.findByName(category).isPresent()))) && (name == null || name.trim().isEmpty())) {
            return taskService.all();
        }else {
            if (category != null && name != null) {
                return taskService.findTasksByCategoryAndName(category, name);
            } else if (category != null) {
                return taskService.findTasksByCategory(category);
            } else {
                return taskService.findTasksByName(name);
            }
        }
    }
}
