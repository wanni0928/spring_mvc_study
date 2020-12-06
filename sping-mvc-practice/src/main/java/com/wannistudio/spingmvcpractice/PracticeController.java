package com.wannistudio.spingmvcpractice;

import org.h2.engine.Session;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("event")
//@RestController
public class PracticeController {
//
//    @GetMapping("/events")
//    public String events() {
//        return "hello";
//    }
//
//    @GetMapping("/events/{id}")
//    public String events2(@PathVariable String id) {
//        return "hello";
//    }
//
//    @DeleteMapping("/events/{id}")
//    public String events4(@PathVariable String id) {
//        return "hello";
//    }
//
//    @PostMapping(value = "/events",
//            consumes = MediaType.APPLICATION_JSON_VALUE
////            produces = MediaType.APPLICATION_JSON_VALUE
//            )
//    public String events3() {
//        return "hello";
//    }
//
//    @PutMapping(value = "events/{id}",
//        consumes = MediaType.APPLICATION_JSON_VALUE
//    )
//    public String events5(@PathVariable String id) {
//        return "hello";
//    }

    @GetMapping("/event/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable Integer id, @MatrixVariable String name) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);
        return event;
    }

//    @PostMapping("/another/{id}")
//    @ResponseBody
//    public Event getRequestParam(@PathVariable Integer id, @RequestParam String name) {
//        Event event = new Event();
//        event.setId(id);
//        event.setName(name);
//        return event;
//    }
//    @PostMapping("/another/{id}")
//    @ResponseBody
//    public Event getRequestParam(@PathVariable Integer id, @RequestParam Map<String, String> params) {
//        Event event = new Event();
//        event.setId(id);
//        event.setName(params.get("name"));
//        return event;
//    }
    @PostMapping("/another/{id}")
    @ResponseBody
    public Event getRequestParam(@ModelAttribute Event event, BindingResult bindingResult) {
//        if(bindingResult.hasErrors()) {
//            bindingResult.getAllErrors().forEach(objectError -> {
//                System.out.println(111111111);
//                System.out.println(objectError.toString());
//            });
//        }
        return event;
    }

//    @GetMapping("/events/form")
//    public String eventsForm(Model model, HttpSession httpSession) {
//        Event event = new Event(1, "와니", 20);
//        model.addAttribute("event", event);
//        httpSession.setAttribute("event", event);
//        return "events/form";
//    }

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model) {
//        Event event = new Event(1, "와니", 20);
        model.addAttribute("event", new Event()); // @SessionAttributes 에 "event"가 등록되어 있어서 자동으로 세션에 저장된다.
        return "events/form-name";
    }
    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Validated @ModelAttribute Event event,
                                       BindingResult bindingResult,
                                       SessionStatus sessionStatus) {
        if(bindingResult.hasErrors()) {
            return "/events/form-name";
        }
//        sessionStatus.setComplete();
        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@Validated @ModelAttribute Event event, Model model) {
        model.addAttribute("event", event);
        return "events/form-limit";
    }
    @PostMapping("/events/form/limit")
    public String eventFormLimitSubmit(@Validated @ModelAttribute Event event,
                                       BindingResult bindingResult,
                                       SessionStatus sessionStatus,
//                                       Model model
                                       RedirectAttributes attributes
    ) {
        if(bindingResult.hasErrors()) {
            return "events/form-limit";
        }
        sessionStatus.setComplete();
//        attributes.addAttribute("name", event.getName()); // String 으로 변환이 불가능한 데이터는 전달 불가능.
        attributes.addFlashAttribute("newEvent", event); // 데이터가 URI에 노출x
        return "redirect:/events/list"; // boot 에서는 model 값들을 자동으로 없애버린다.
    }
    @GetMapping("/events/list")
    public String getEvents(@ModelAttribute("newEvent") Event event, Model model, @SessionAttribute LocalDateTime visitTime) {
        System.out.println(visitTime);
        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event(1, "wanni", 20));
        eventList.add(new Event(2, "curry", 20));
        model.addAttribute(eventList);
        return "events/list";
    }


//    @PostMapping("/events")
//    @ResponseBody
//    public Event getEvent(@Validated @RequestParam String name, @RequestParam Integer limit) {
//        Event event = new Event();
//        event.setName(name);
//        event.setLimit(limit);
//        return event;
//    }
    @PostMapping("/events")
//    @ResponseBody
    public String createEvent(@Validated @ModelAttribute Event event, BindingResult bindingResult, SessionStatus sessionStatus) {
        if(bindingResult.hasErrors()) {
            return "events/form";
        }
        sessionStatus.setComplete();
        return "redirect:/events/list"; //@GetMapping("/events/list)로 매핑된다.
    }
}