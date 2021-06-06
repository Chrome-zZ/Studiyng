package org.example.simple.controller;

import org.example.simple.model.User;
import org.example.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('write')")
    public List<User> getAll() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('read')")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('read')") //idk if it's necessary
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}