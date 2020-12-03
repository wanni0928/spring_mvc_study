package com.wannistudio.webmvcconfigurer;

import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

//    @GetMapping("/hello/{name}")
//    public String hello(@PathVariable String name) {
//        return "hello " + name;
//    }

//    @GetMapping("/hello/{name}")
//    public String hello(@PathVariable("name") Person person) {
//        return "hello " + person.getName();
//    }

    @GetMapping("/hello")
    public String hello(@RequestParam("id") Person person) {
        return "hello " + person.getName();
    }

    @GetMapping("/message")
    public String message(@RequestBody String body) {
        return body;
    }

    @GetMapping("/jsonMessage")
    public Person jsonMessage(@RequestBody Person person) {
        return person;
    }
}
