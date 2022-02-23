package ru.kata.spring.boot_security.demo.controller;

import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping(value = "/login")
    public String registration() {
        return "login";
    }

    @GetMapping(value = "/admin")
    public String adminPage(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin";
    }

    @GetMapping("/create")
    public String getCreateUser(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute("user") User user,
                             @RequestParam("roles") ArrayList<Long> roles) {

        Set<Role> roleSet = new HashSet<>((Collection<? extends Role>)
                roleService.findAllById(roles));
        user.setRoles(roleSet);
        userService.save(user);
        return "redirect:/admin";
    }


    @GetMapping("/edit/{id}")
    public String getEditUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleService.findAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") User user,
                           @RequestParam("roles") ArrayList<Long> roles) {

        Set<Role> roleSet = new HashSet<>((Collection<? extends Role>)
                roleService.findAllById(roles));
        user.setRoles(roleSet);
        userService.save(user);
        return "redirect:/admin";
    }


    @PostMapping("/{id}/remove")
    public String userDelete(@PathVariable(value = "id") Long id, Model model) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

    @GetMapping("/user")
    public String pageForUser(Model model, Principal principal) {
        model.addAttribute("user", userService.findByUserName(principal.getName()));
        return "user";
    }
}
