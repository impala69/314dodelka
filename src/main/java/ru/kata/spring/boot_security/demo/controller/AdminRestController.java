package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("api")
public class AdminRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleServise;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers () {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping( "/users/{id}")
    public User getUser (@PathVariable Long id){
        return userService.findById(id);
    }

    @PostMapping ("/users")
    public void addUser (@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping( "/users/{id}")
    public void deleteUser (@PathVariable Long id){
        User user = userService.findById(id);
        userService.delete(user);
    }

    @GetMapping("/name")
    public ResponseEntity<User> getAdminByName(Principal principal) {
        return ResponseEntity.ok(userService.getUserByEmail(principal.getName()));
    }


}
