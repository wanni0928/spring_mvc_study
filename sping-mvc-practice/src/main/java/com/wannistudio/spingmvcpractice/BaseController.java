package com.wannistudio.spingmvcpractice;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@ControllerAdvice(assignableTypes = {PracticeController.class, SampleController.class})
@ControllerAdvice("com.wannistudio.spingmvcpractice")
public class BaseController {
    @ExceptionHandler({EventException.class, RuntimeException.class})
    public ResponseEntity eventErrorHandler() {
//        model.addAttribute("message", "event error");
//        return "error";
        return ResponseEntity.badRequest().body("error");
    }

    @InitBinder
    public void initEventBinder(WebDataBinder webDataBinder) { // 모든 요청을 적용하기 전에 이 메소드를 거친다.
        webDataBinder.setDisallowedFields("id"); // 특정 필드를 보내더라도, 바인딩 해주지 않는다.(바인딩 설정)
    }

    @ModelAttribute
    public void categories(Model model) {
        model.addAttribute("categories", Stream.of("study", "seminar", "lecture").collect(Collectors.toList()));
    }
}
