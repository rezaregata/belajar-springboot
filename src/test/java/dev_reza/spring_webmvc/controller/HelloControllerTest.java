package dev_reza.spring_webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import dev_reza.spring_webmvc.service.HelloService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Reza Regata
 */
// @SpringBootTest
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HelloService helloService;

    @BeforeEach
    void setUp() {
        Mockito.when(helloService.hello(Mockito.anyString()))
        .thenReturn("Hello Guest");
    }

    @Test
    public void helloGuest() throws Exception {
        mockMvc.perform(
                get("/hello")
                .queryParam("name", "Reza")
        ).andExpectAll(
                status().isOk(),
                content().string(
                        Matchers.containsString("Hello Guest")
                ));
    }

    @Test
    public void helloName() throws Exception {
        mockMvc.perform(
                get("/hello")
                        .queryParam("name", "Reza")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Hello Reza"))
        );
    }

    @Test
    public void notAllowed() throws Exception {
        mockMvc.perform(
                post("/hello")
                        .queryParam("name", "Reza")
        ).andExpect(
                status().isMethodNotAllowed()
        );
    }

}
