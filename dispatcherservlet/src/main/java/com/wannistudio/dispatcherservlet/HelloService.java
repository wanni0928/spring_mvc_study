package com.wannistudio.dispatcherservlet;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getName() {
        return "wanni";
    }
}
