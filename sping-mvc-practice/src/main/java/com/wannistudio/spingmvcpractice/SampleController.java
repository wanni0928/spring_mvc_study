package com.wannistudio.spingmvcpractice;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

//    @RequestMapping(value = "/hello", method = {RequestMethod.GET, RequestMethod.PUT}) // 특정 메소드를 에노테이션으로 정의하지 않으면 모든 http 요청을 허용하게 된다.
//    @GetMapping(value = {"/hello", "/hello.*"}) // hello.json, hello.xml, hello.html 과 같은 uri도 매핑을 할 수 있게금 암묵적으로 hello.* 도 선언해주곤 한다. 하지만 RFD attack 이슈로 잘 안씀.
    @GetMapping(value = "/hello") // 대신 헤더에 contentType을 정의해서 특정 자료형을 받는 쪽을 권장한다.
    @ResponseBody // 템플릿이 아니라 특정 텍스트 타입으로 반환하고 싶을 때. (메세지 '바디' 를 response 하고 싶을 때.)
    public String hello() {
        return "hello";
    }

    @GetMapping(value = "/wanni?")
    @ResponseBody
    public String wanniHello() {
        return "hello";
    }

    @GetMapping(value = "/curry/?")
    @ResponseBody
    public String curryHello() {
        return "hello";
    }

    @GetMapping(value = "/curry/*")
    @ResponseBody
    public String curryHelloAstar() {
        return "hello";
    }

    @GetMapping(value = "/wanni/**")
    @ResponseBody
    public String wanniHelloAstars() {
        return "hello";
    }

    @GetMapping(value = "/scottishfold", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String scottishFold() {
        return "hello";
    }
}
