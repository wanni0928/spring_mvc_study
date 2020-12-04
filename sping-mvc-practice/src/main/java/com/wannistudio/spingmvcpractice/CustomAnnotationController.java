package com.wannistudio.spingmvcpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomAnnotationController {

    @GetHelloMapping
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
