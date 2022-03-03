package ru.kata.spring.boot_security.demo.configs;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class TestData {

    private final RoleService roleService;
    private final UserService userService;

    public TestData(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }
    @PostConstruct
    void postConstruct() {
        Role admin = new Role("ADMIN");
        Role user = new Role("USER");
        roleService.save(admin);
        roleService.save(user);

        userService.save(new User("admin@mail.ru", "1234","Admin","Admin",20, Set.of(admin)));
        userService.save(new User("max@mail.ru","1234","Max","Titov",24,Set.of(user)));
        userService.save(new User("love@mail.ru", "2222","Lubov","Muratova",18, Set.of(user)));

    }
}