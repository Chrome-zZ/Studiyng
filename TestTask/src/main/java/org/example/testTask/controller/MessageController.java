package org.example.testTask.controller;

import org.example.testTask.dto.MessageDTO;
import org.example.testTask.model.Message;
import org.example.testTask.repository.MessageRepository;
import org.example.testTask.repository.UserRepository;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageRepository messageRepository;
    private final UserController userController;
    private final UserRepository userRepository;

    public MessageController(MessageRepository messageRepository, UserController userController, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userController = userController;
        this.userRepository = userRepository;
    }

    @PostMapping
    public Message saveMessage(@RequestBody MessageDTO messageDTO){
        Message newMessage = new Message();
        newMessage.setUser(userRepository.findByLogin(messageDTO.getName()).get());
        newMessage.setText(messageDTO.getMessage());
        newMessage.setCreationDate(LocalDateTime.now());
        return messageRepository.save(newMessage);
    }
    //получение токена из сообщения
    public void getTokenFromMessage(MessageDTO messageDTO) {
        String[] strings = messageDTO.getMessage().split("\\s");
        String token = strings[1];
        userRepository.findByLogin(messageDTO.getName()).get().setToken(token);
        String string = userController.getUserAuth(messageDTO.getName(), token);
        System.out.println(string);
    }

    //обработка сообщения для ws
    @MessageMapping("/chat")
    public void processMessage(@Payload MessageDTO messageDTO) {
        String login = messageDTO.getName();
        if (messageDTO.getMessage().contains("auth")) {
            getTokenFromMessage(messageDTO);
        }
        if (messageDTO.getMessage().contains("history 10") && userController
                .getUserAuth(login,
                        userRepository.findByLogin(login).get().getToken()).equals("Success")) {
            messageHistory(messageDTO.getName());
        } else if (userController.getUserAuth(login,
                userRepository.findByLogin(login).get().getToken()).equals("Success")) {
           saveMessage(messageDTO);
        }
    }

    //    @GetMapping("/{login}")
    //вывод последних 10 сообщений для пользователя
    public void messageHistory(/*@PathVariable*/ String login) {
        messageRepository.findLast10Messages(login);
    }
}
