package kg.itSphere.CTF.controller;

import kg.itSphere.CTF.dto.MyData;
import kg.itSphere.CTF.dto.event.EventRequest;
import kg.itSphere.CTF.dto.task.CategoryRequest;
import kg.itSphere.CTF.dto.task.TaskRequest;
import kg.itSphere.CTF.services.AdminService;
import kg.itSphere.CTF.services.impl.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    @PostMapping("/task/add")
    public MyData addTask(@RequestBody TaskRequest taskRequest
                      ){
        MyData data = new MyData();
        adminService.addTask(taskRequest );
        data.setMessage("Task added successfully");
        return data;
    }
    //hi
    @PutMapping("/task/updateById/{taskId}")
    public MyData updateTask(@RequestBody TaskRequest taskRequest
                             ,
                             @PathVariable Long taskId){
        adminService.updateTask(taskId , taskRequest);
        MyData data = new MyData();
        data.setMessage("Task updated successfully");
        return data;
    }
    @DeleteMapping("/task/deleteById/{taskId}")
    public  MyData deleteById(@PathVariable Long taskId){
        adminService.deleteTask(taskId);
        MyData data = new MyData();
        data.setMessage("Task deleted successfully");
        return data;
    }
    @PostMapping("/category/add")
    public MyData addCategory(@RequestBody CategoryRequest categoryRequest){
        adminService.addCategory(categoryRequest);
        MyData data = new MyData();
        data.setMessage("Category added successfully");
        return data ;
    }

    @PostMapping("/event/add")
    public MyData addEvent(@RequestBody EventRequest eventRequest){
        adminService.addEvent(eventRequest);
        MyData data = new MyData();
        data.setMessage("Event added successfully");
        return data;
    }

}
