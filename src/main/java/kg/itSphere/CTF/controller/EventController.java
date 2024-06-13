package kg.itSphere.CTF.controller;

import kg.itSphere.CTF.services.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;

    @GetMapping()
    public String allEvents(Model model){
        model.addAttribute("events",  eventService.getAllEvents());
        return "events";
    }

}
