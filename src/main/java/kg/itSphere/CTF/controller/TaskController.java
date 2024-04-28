package kg.itSphere.CTF.controller;

import kg.itSphere.CTF.dto.task.TaskDetailResponse;
import kg.itSphere.CTF.dto.task.TaskResponse;
import kg.itSphere.CTF.entities.Task;
import kg.itSphere.CTF.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
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

}
