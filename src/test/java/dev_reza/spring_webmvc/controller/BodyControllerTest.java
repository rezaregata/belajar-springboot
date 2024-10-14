//package dev_reza.spring_webmvc.controller;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import dev_reza.spring_webmvc.model.HelloRequest;
//import dev_reza.spring_webmvc.model.HelloResponse;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class BodyControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
//    @Test
//    public void requestBodyTest(){
//        HelloRequest request = new HelloRequest();
//        request.setName("Reza");
//
//        mockMvc.perform(
//            post("body/hello")
//            .contentType(MediaType.APPLICATION_JSON)
//            .content(objectMapper.writeValueAsString(request))
//        ).andExpectAll(
//            status().isOk()
//        ).andExpect( result -> {
//            String responseBody = result.getResponse().getContentAsString();
//            HelloResponse helloResponse = objectMapper.read
//        }
//
//        )
//    }
//}
