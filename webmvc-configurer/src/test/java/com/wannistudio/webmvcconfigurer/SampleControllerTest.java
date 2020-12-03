package com.wannistudio.webmvcconfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

//MockMvc를 사용할 수 있다. 이 애노테이션은 웹과 관련된 빈만 등록하게 한다. 자세한건 직접 들어가봐서 소스코드를 확인해본다.
@SpringBootTest
//@WebMvcTest
@AutoConfigureMockMvc
class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void jsonMessage() throws Exception {
        Person person = new Person();
        person.setId(2020L);
        person.setName("wanni");

        String jsonString = objectMapper.writeValueAsString(person);

        this.mockMvc.perform(get("/jsonMessage")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                    .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void hello() throws Exception {
        Person person = new Person();
        person.setName("wanni");
        Person save = personRepository.save(person);

        this.mockMvc.perform(get("/hello")
                .param("id", save.getId().toString()))
                .andDo(print())
                .andExpect(content().string("hello wanni"));
    }

    @Test
    public void helloStatic() throws Exception {
        this.mockMvc.perform(get("/mobile/index.html"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Hello mobile")))
                .andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
    }

    @Test
    public void stringMessage() throws Exception {
        this.mockMvc.perform(get("/message")
            .content("hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }
}