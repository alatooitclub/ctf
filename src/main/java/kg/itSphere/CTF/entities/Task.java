package kg.itSphere.CTF.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ctf")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name can't be empty")
    private String name;
    private String description;
    @NotEmpty(message = "Category can't be empty")
    private String category;
    @NotEmpty(message = "Flag can't be empty")
    private String flag;
    private String hint;
    private String author;
    @NotNull(message = "Points can't be empty")
    private String points;
    private String status;
    @OneToOne
    @JoinColumn
    private Image image;
}