package dev_reza.spring_webmvc.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FormController {

        private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

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

    @PostMapping(path = "/form/person", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public String createPerson(
        @RequestParam(name = "name") String name,
        @RequestParam(name = "birthDate") Date birthDate,
        @RequestParam(name = "address") String address
    ){
        return "Success create person with name " + name +
                ", birthday " + dateFormat.format(birthDate) +
                ", address " + address;
    }
}
