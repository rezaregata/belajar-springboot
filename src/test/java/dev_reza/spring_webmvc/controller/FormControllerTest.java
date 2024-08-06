package dev_reza.spring_webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class FormControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void formTest() throws Exception {
        mockMvc.perform(
                post("/form")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .queryParam("name", "Reza")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Reza")));

    }

    @Test
    void formSecond() throws Exception {
        mockMvc.perform(
                post("/formsecond")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("name", "Reza")
        ).andExpectAll(
                status().isOk(),
                header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                content().string(Matchers.containsString("Hello Reza"))
        );
    }
}
