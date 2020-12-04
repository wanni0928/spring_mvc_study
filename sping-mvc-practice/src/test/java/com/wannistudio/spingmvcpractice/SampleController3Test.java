package com.wannistudio.spingmvcpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class SampleController3Test {
    @Autowired
    MockMvc mockMvc;

    @Test
    void httpHeaderTest() throws Exception {
        mockMvc.perform(get("/world/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}