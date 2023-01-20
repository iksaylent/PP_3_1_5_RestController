package ru.kata.spring.boot_security.demo.util;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class Util {
    private final UserService userService;
    private final RoleService roleService;

    public Util(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initializeDB() {
        roleService.addRole(new Role("ROLE_ADMIN"));
        roleService.addRole(new Role("ROLE_USER"));
        userService.addUser(new User("admin", "admin", "admin@admin.ru",
                "admin", Set.of(new Role(1L, "ROLE_ADMIN"))));
        userService.addUser(new User("user", "user", "user@user.ru",
                "user", Set.of(new Role(2L, "ROLE_USER"))));

    }
}
