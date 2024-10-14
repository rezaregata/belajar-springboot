package dev_reza.spring_webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CodeController {

    @DeleteMapping(path = "/products/{id}")
//    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") Integer id){
        // delete from database
    }
}
