package org.example.simple.controller;

import org.example.simple.model.User;
import org.example.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('users:read')")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('users:write')")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}