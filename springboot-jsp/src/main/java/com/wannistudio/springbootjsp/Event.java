package com.wannistudio.springbootjsp;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Event {
    private String name;
    private LocalDateTime starts;

}
