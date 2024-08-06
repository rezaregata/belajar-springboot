package dev_reza.spring_webmvc.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class HelloControllerIntegrationTest {

    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void helloGuest() throws Exception {
        String response = testRestTemplate.getForEntity("http://localhost:" + port + "/hello", String.class).getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello Guest", response.trim());
    }

    @Test
    public void helloName() throws Exception {
        String response = testRestTemplate.getForEntity("http://localhost:" + port + "/hello?name=Reza", String.class).getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals("Hello Reza", response.trim());
    }

}
