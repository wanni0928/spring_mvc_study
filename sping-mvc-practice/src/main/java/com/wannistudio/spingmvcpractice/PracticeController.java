package com.wannistudio.spingmvcpractice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PracticeController {

    @GetMapping("/events")
    public String events() {
        return "hello";
    }

    @GetMapping("/events/{id}")
    public String events2(@PathVariable String id) {
        return "hello";
    }

    @DeleteMapping("/events/{id}")
    public String events4(@PathVariable String id) {
        return "hello";
    }

    @PostMapping(value = "/events",
            consumes = MediaType.APPLICATION_JSON_VALUE
//            produces = MediaType.APPLICATION_JSON_VALUE
            )
    public String events3() {
        return "hello";
    }

    @PutMapping(value = "events/{id}",
        consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public String events5(@PathVariable String id) {
        return "hello";
    }
}
