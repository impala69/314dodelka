package ru.kata.spring.boot_security.demo.service;



import ru.kata.spring.boot_security.demo.models.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void deleteUser(long id);

    void editUser(User user, long id);

    User getUserByName(String name);

    List<User> getAllUsers();

    User getUserById(long id);
}
