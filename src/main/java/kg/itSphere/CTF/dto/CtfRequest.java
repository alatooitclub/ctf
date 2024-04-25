package kg.itSphere.CTF.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CtfRequest {
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
