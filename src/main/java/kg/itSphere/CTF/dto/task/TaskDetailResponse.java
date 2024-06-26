package kg.itSphere.CTF.dto.task;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDetailResponse {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String flag;
    private String hint;
    private Integer rating;
    private Integer solves;
    private Integer points;
    private String status;
}
