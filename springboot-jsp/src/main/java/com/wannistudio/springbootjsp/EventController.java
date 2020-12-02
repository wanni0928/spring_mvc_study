package com.wannistudio.springbootjsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class EventController {
    @GetMapping("/events")
    public String getEvents(Model model) {
        Event event1 = new Event();
        event1.setName("spring1");
        event1.setStarts(LocalDateTime.of(2020, 12, 3, 10, 0));
        Event event2 = new Event();
        event2.setName("spring2");
        event2.setStarts(LocalDateTime.of(2020, 12, 12, 10, 0));

        List<Event> events = Stream.of(event1, event2).collect(Collectors.toList());
        model.addAttribute("events", events);
        model.addAttribute("message", "Happy soonoong");
        return "events/list";
    }
}
