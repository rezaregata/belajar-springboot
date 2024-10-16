package dev_reza.spring_webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Reza")
                        .param("middleName", "R")
                        .param("lastName", "Regata")
                        .param("email", "reza@gmail.com")
                        .param("phoneNumber", "123")
                        .param("address.street", "jalan kebon sirih")
                        .param("address.city", "bandung")
                        .param("address.state", "jawa barat")
                        .param("address.zipCode", "123")
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Reading")
                        .param("socialMedias[0].name", "X")
                        .param("socialMedias[0].location", "Twitter")
                        .param("socialMedias[1].name", "Meta")
                        .param("socialMedias[1].location", "Facebook")
        ).andExpectAll(
                status().isOk(),
                content().string(
                        Matchers.containsString("Successfully created a new person with Reza R Regata reza@gmail.com 123 jalan kebon sirih bandung jawa barat 123"))
        );
    }
}