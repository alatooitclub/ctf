package kg.itSphere.CTF.services.impl;

import kg.itSphere.CTF.dto.task.TaskRequest;
import kg.itSphere.CTF.entities.Image;
import kg.itSphere.CTF.entities.Task;
import kg.itSphere.CTF.mapper.TaskMapper;
import kg.itSphere.CTF.repository.ImageRepository;
import kg.itSphere.CTF.repository.TaskRepository;
import kg.itSphere.CTF.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final ImageRepository imageRepository;
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    @Override
    public void addTask(TaskRequest taskRequest) {

        Task task = new Task();
        taskRepository.save(taskMapper.toDtoTask(task , taskRequest ));
    }

}
