package ru.kata.spring.boot_security.demo.util;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Component
public class Util implements CommandLineRunner {

    private UserService userService;
    private RoleService roleService;

    public Util(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Role admin = new Role();
        admin.setRoleName("ROLE_ADMIN");
        roleService.createRole(admin);
        Role user = new Role();
        user.setRoleName("ROLE_USER");
        roleService.createRole(user);

        User userAdmin = new User();
        userAdmin.setUsername("admin");
        userAdmin.setPassword("admin");
        userAdmin.setName("admin");
        userAdmin.setSurname("admin");
        userAdmin.setAge(35);
        userAdmin.setEmail("admin@mail.ru");
        userService.createUser(userAdmin);
        userAdmin.addRoleToUser(admin);
        userAdmin.addRoleToUser(user);
        userService.updateUser(userAdmin, userAdmin.getId());

        User userUser = new User();
        userUser.setUsername("user");
        userUser.setPassword("user");
        userUser.setName("user");
        userUser.setSurname("user");
        userUser.setAge(30);
        userUser.setEmail("user@mail.ru");
        userService.createUser(userUser);
        userUser.addRoleToUser(user);
        userService.updateUser(userUser, userUser.getId());

    }
}

