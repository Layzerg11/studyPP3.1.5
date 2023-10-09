package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @GetMapping("/adminBootstrap")
    public String pageForAdmin() {
        return "adminBootstrap";
    }

    @GetMapping("/userBootstrap")
    public String showOneUser() {
        return "userBootstrap";
    }
}
