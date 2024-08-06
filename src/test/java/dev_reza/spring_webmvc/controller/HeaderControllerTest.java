package dev_reza.spring_webmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
// import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class HeaderControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void headerOk() throws Exception {
                mockMvc.perform(
                        get("/header/token")
                        .header("X-TOKEN", "Reza")
                ).andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Oke"))
                );
        }

        @Test
        public void headerNotOk() throws Exception {
                mockMvc.perform(
                        get("/header/token")
                        .header("X-TOKEN", "Re")
                ).andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Not Oke"))
                );
        }
}
