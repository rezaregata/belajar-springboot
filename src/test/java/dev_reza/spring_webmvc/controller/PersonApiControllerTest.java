package dev_reza.spring_webmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev_reza.spring_webmvc.model.CreateAddressRequest;
import dev_reza.spring_webmvc.model.CreatePersonRequest;
import dev_reza.spring_webmvc.model.CreateSocialMediaRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPerson() throws Exception {
        CreatePersonRequest request = new CreatePersonRequest();
        request.setFirstName("Reza");
        request.setMiddleName("R");
        request.setLastName("Regata");
        request.setEmail("reza@gmail.com");
        request.setPhoneNumber("123");
        request.setAddress(new CreateAddressRequest("Jalan kebon sirih", "bandung", "jawa barat", "123"));
        request.setHobbies(List.of("Coding", "Reading"));
        request.setSocialMedias(new ArrayList<>());
        request.getSocialMedias().add(new CreateSocialMediaRequest("X", "Twitter"));
        request.getSocialMedias().add(new CreateSocialMediaRequest("Meta", "Facebook"));

        mockMvc.perform(
                post("/api/person")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpectAll(
                status().isOk(),
                content().json(objectMapper.writeValueAsString(request))
        );
    }

}