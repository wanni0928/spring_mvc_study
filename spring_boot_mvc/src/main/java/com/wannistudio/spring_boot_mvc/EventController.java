package com.wannistudio.spring_boot_mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;

//    @RequestMapping(value = "/events", method = RequestMethod.GET)
    @GetMapping(value = "/events") // 4.3 부터는 이런식으로 사용. 4.3 이전에는 security 이슈가 있어, 사용을 지양한다.
    public String events(Model model) {
        model.addAttribute("events", eventService.getEvents());
        return "events";
    }
}
