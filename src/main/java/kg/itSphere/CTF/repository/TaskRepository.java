package kg.itSphere.CTF.repository;

import kg.itSphere.CTF.entities.Category;
import kg.itSphere.CTF.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long>{
    Optional<Task> findByName(String name);
    List<Task> findAllByCategory(String category);
}
