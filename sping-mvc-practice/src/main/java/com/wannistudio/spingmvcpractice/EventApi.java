package com.wannistudio.spingmvcpractice;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventApi {
//    @PostMapping
//    public Event createEvent(@Valid @RequestBody Event event, BindingResult bindingResult) {
//        // save event
//        if(bindingResult.hasErrors()) {
//            bindingResult.getAllErrors().forEach(error -> {
//                System.out.println(error.toString());
//            });
//        }
//        return event;
//    }

//    @PostMapping
//    public Event createEvent(HttpEntity<Event> request) {
//        // save
//        MediaType contentType
//                = request.getHeaders().getContentType();
//        System.out.println(contentType);
//        return request.getBody();
//    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody @Valid Event event, BindingResult bindingResult) {
        // save event
        if(bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(event);
    }
}
