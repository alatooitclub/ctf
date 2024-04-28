package kg.itSphere.CTF.controller;

import kg.itSphere.CTF.dto.MyData;
import kg.itSphere.CTF.dto.task.TaskRequest;
import kg.itSphere.CTF.services.impl.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminServiceImpl adminService;
    @PostMapping("/task/add")
    public MyData addTask(@RequestBody TaskRequest taskRequest
                      ){
        MyData data = new MyData();
        adminService.addTask(taskRequest );
        data.setMessage("Task added successfully");
        return data;
    }
    @GetMapping("/task/updateById/{taskId}")
    public MyData updateTask(@RequestBody TaskRequest taskRequest
                             ,
                             @PathVariable Long taskId){
        MyData data = new MyData();
        data.setMessage("Task updated successfully");
        return data;
    }
}
