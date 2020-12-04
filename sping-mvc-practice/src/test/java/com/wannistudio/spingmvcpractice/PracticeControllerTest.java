package com.wannistudio.spingmvcpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class PracticeControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void customAnnotation() throws Exception {
        mockMvc.perform(get("/aloha"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getEvents() throws Exception {
        mockMvc.perform(get("/events"))
                .andExpect(status().isOk());
    }

    @Test
    void getEvents2() throws Exception {
        mockMvc.perform(get("/events/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getEvents3() throws Exception {
        mockMvc.perform(post("/events")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getEvents4() throws Exception {
        mockMvc.perform(delete("/events/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void putEvents() throws Exception {
        mockMvc.perform(put("/events/1")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
}