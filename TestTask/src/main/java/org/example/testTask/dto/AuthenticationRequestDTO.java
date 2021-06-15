package org.example.testTask.dto;


import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String login;
    private String password;
}