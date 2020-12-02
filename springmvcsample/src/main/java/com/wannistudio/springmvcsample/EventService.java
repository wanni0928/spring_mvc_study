package com.wannistudio.springmvcsample;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EventService {
    public List<Event> getEvents() {
        Event event = Event.builder()
                .name("springMVC")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020,12,1,10, 0))
                .endDateTime(LocalDateTime.of(2020,12,1,12, 0))
                .build();

        Event event2 = Event.builder()
                .name("springMVC")
                .limitOfEnrollment(5)
                .startDateTime(LocalDateTime.of(2020,12,8,10, 0))
                .endDateTime(LocalDateTime.of(2020,12,8,12, 0))
                .build();

        return Stream.of(event, event2).collect(Collectors.toList());
    }
}
