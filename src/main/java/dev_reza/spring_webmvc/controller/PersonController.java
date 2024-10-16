package dev_reza.spring_webmvc.controller;

import dev_reza.spring_webmvc.model.CreatePersonRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Reza Regata
 * @created 16/10/2024 - 21:18
 **/

@RestController
public class PersonController {

    @PostMapping(path = "/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public String createPerson(@ModelAttribute CreatePersonRequest request){
        System.out.println(request);
        return new StringBuilder().append("Successfully created a new person with ")
                .append(request.getFirstName()).append(" ")
                .append(request.getMiddleName()).append(" ")
                .append(request.getLastName()).append(" ")
                .append(request.getEmail()).append(" ")
                .append(request.getPhoneNumber()).append(" ")
                .append(request.getAddress().getStreet()).append(" ")
                .append(request.getAddress().getCity()).append(" ")
                .append(request.getAddress().getState()).append(" ")
                .append(request.getAddress().getZipCode()).append(" ")
                .toString();
    }


}
