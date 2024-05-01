package kg.itSphere.CTF.dto.event;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
public class EventRequest {
    private String name;
    private DateTimeRequest dateStart;
    private DateTimeRequest dateEnd;
    private String location = "Online";
    private String format;
    private String description;
}
