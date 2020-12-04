package com.wannistudio.spingmvcpractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/cat")
public class SampleController2 {
    @GetMapping(value = "/**")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
