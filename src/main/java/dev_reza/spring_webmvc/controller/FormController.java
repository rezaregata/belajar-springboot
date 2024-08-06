package dev_reza.spring_webmvc.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

    @PostMapping(path = "/form", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String form(@RequestParam(name = "name") String name) {
        return "Hello " + name;
    }

    @PostMapping(
            path = "/formsecond",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_HTML_VALUE
    )
    @ResponseBody
    public String formSecond(@RequestParam(name = "name") String name) {
        return """
        <div>Hello $name</div>
        """.replace("$name", name);
    }
}
