package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.security.Principal;

@Controller
public class ViewController {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public ViewController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String loginPage() {
        return "login";
    }

    @GetMapping("/adminBootstrap")
    public String pageForAdmin(Model model, Principal principal) {
        System.out.println("Work adminController");
        model.addAttribute("admin", userService.findByUsername(principal.getName()));
        model.addAttribute("users", userService.getUserList());
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.findAllRoles());
        return "adminBootstrap";
    }

    @GetMapping("/userBootstrap")
    public String showOneUser() {
        return "userBootstrap";
    }
}
