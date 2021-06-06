package org.example.simple.dto;


import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String login;
    private String password;
}
