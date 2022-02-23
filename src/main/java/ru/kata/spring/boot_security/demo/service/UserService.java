package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    void save(User user);
    void deleteUserById(Long id);

    User findById(Long id);
    User findByUserName (String username);

}
