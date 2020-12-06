package com.wannistudio.spingmvcpractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
//@EnableWebMvc
class UriPatternTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void deleteEvent() throws Exception {
        mockMvc.perform(get("/event/1;name=wanni"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
        ;
    }

    @Test
    void getRequestParam() throws Exception {
        mockMvc.perform(post("/another/1")
                    .param("id", "1")
                    .param("name", "null")
                    .param("limit", "-1")
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("wanni"))
        ;
    }

    @Test
    void checkEventForm() throws Exception {
        Objects.requireNonNull(mockMvc.perform(get("/events/form"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("events/form"))
                .andExpect(model().attributeExists("event"))
                .andExpect(request().sessionAttribute("event", notNullValue()))
                .andReturn().getRequest().getSession()).getAttribute("event")
        ;
    }

    @Test
    void checkPostEvent() throws Exception {
        ResultActions result = mockMvc.perform(post("/events")
                .param("id", "1")
                .param("name", "wanni")
                .param("limit", "-10")
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().hasErrors());
        ModelAndView modelAndView = result.andReturn().getModelAndView();
        Map<String, Object> model = modelAndView.getModel();
        System.out.println(model.size());
    }

    @Test
    void getEvents() throws Exception {
        Event newEvent = new Event();
        newEvent.setName("wanni");
        newEvent.setLimit(9999);

        mockMvc.perform(get("/events/list")
            .sessionAttr("visitTime", LocalDateTime.now())
            .flashAttr("newEvent", newEvent)
        ).andDo(print())
                .andExpect(status().isOk())
                ;
    }
}