package dev_reza.spring_webmvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Test
        public void getOrder() throws Exception {
                mockMvc.perform(
                        get("/orders/11/products/123")
                ).andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Orders 11 Products 123"))
                );
        }

}
