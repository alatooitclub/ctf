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
    @PostMapping("/task/add/{imageId}")
    public MyData addTask(@RequestBody TaskRequest taskRequest ,
                        @PathVariable Long imageId){
        MyData data = new MyData();
        adminService.addTask(taskRequest , imageId);
        data.setMessage("Task added successfully");
        return data;
    }
    @GetMapping("/task/updateById/{taskId}/{imageId}")
    public MyData updateTask(@RequestBody TaskRequest taskRequest ,
                             @PathVariable Long imageId,
                             @PathVariable Long taskId){
        MyData data = new MyData();
        data.setMessage("Task updated successfully");
        return data;
    }
}
