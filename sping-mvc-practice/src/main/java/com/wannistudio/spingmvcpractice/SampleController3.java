package com.wannistudio.spingmvcpractice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController3 {
    @GetMapping(value = "/world/{id}"
//            , headers = HttpHeaders.FROM
//            ,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            ,produces = MediaType.TEXT_PLAIN_VALUE
    )
    @ResponseBody
    public String hello(@PathVariable String id) {
        return id;
    }
}
