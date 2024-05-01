package kg.itSphere.CTF.dto.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DateTimeRequest {
    private Integer year;
    private Integer month;
    private Integer day;
    private Integer hour;
    private Integer minute;
    private Integer seconds;
}
