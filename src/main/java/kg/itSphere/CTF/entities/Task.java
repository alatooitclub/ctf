package kg.itSphere.CTF.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import kg.itSphere.CTF.enums.TaskDifficulty;
import kg.itSphere.CTF.enums.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String flag;
    private Integer rating = 0;
    private Integer solves = 0;
    @Enumerated(EnumType.STRING)
    private TaskDifficulty difficulty;
    private String author;
    private Integer points;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @OneToOne
    @JoinColumn
    private Category category;
    @OneToMany
    private List<Hint> hintList;
}