package org.example.simple.controller;


import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String login;
    private String password;
}
