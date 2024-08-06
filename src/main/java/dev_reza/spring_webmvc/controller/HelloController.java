package dev_reza.spring_webmvc.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dev_reza.spring_webmvc.service.HelloService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public void helloWorld(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String name = request.getParameter("name");
        // if (Objects.isNull(name)) {
        //     name = "Guest";
        // }
        // response.getWriter().println("Hello " + name);
        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }

    @GetMapping(path = "/helloGet")
    public void helloGet(
            @RequestParam(name = "name", required = false) String name, HttpServletResponse response) throws IOException {

        String responseBody = helloService.hello(name);
        response.getWriter().println(responseBody);
    }
}
