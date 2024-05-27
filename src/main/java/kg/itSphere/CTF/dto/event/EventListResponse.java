package kg.itSphere.CTF.dto.event;

import kg.itSphere.CTF.dto.image.ImageResponse;

public class EventListResponse {
    private Long id;
    private ImageResponse image;
    private String name;
    private String startDate;
    private String endDate;
    private Integer usersCount;
}
