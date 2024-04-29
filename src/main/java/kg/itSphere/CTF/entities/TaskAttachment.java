package kg.itSphere.CTF.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TaskAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(name = "path")
    private String path;
}
