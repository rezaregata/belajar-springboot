package dev_reza.spring_webmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Reza Regata
 * @created 14/10/2024 - 21:49
 **/

@RestController
public class AuthController {

    @PostMapping(path = "/auth/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> login(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            HttpServletResponse servletResponse
    ){
        if ("reza".equals(username) && "rahasia".equals(password)){
            Cookie cookie = new Cookie("username", username);
            cookie.setPath("/");
            servletResponse.addCookie(cookie);

            return new ResponseEntity<>("OK", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("KO", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping(path = "/auth/user")
    public ResponseEntity<String> getUser(@CookieValue("username") String username){
        return new ResponseEntity<>("Hello " + username, HttpStatus.OK);
    }

}
