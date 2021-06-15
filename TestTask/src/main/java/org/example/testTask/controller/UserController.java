package org.example.testTask.controller;

import org.example.testTask.model.User;
import org.example.testTask.repository.MessageRepository;
import org.example.testTask.repository.UserRepository;
import org.example.testTask.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public UserController(JwtTokenProvider jwtTokenProvider, UserRepository userRepository,
                          MessageRepository messageRepository) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @GetMapping
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    //    @GetMapping("/{login}")
    // проверка токена авторизации
    public String getUserAuth(/*@PathVariable*/ String login, String token) {
        if (jwtTokenProvider.getUserName(token).equals(userRepository.findByLogin(login).get().getLogin())) {
            return "Success";
        }
        return "Invalid user authentication";
    }
}