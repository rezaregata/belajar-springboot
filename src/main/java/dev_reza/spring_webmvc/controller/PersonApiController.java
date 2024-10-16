package dev_reza.spring_webmvc.controller;

import dev_reza.spring_webmvc.model.CreatePersonRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Reza Regata
 * @created 16/10/2024 - 22:11
 **/

@RestController
public class PersonApiController {

    @PostMapping(
            path = "/api/person",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CreatePersonRequest createPerson(@RequestBody CreatePersonRequest request) {
        return request;
    }

}
