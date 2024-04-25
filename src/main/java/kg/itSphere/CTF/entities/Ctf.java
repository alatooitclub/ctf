package kg.itSphere.CTF.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ctf")
public class Ctf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private String flag;
    private String hint;
    private String file;
    private String author;
    private String points;
    private String status;
}