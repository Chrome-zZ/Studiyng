package org.example.simple.service;


import org.example.simple.model.Status;
import org.example.simple.model.User;
import org.example.simple.repo.ScheduleRepo;
import org.example.simple.repo.UserRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final ScheduleService scheduleService;

    public UserService(UserRepo userRepo, ScheduleService scheduleService) {
        this.userRepo = userRepo;
        this.scheduleService = scheduleService;
    }

    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) {

        User newU = new User();
        newU.setLogin(user.getLogin());
        newU.setRole(user.getRole());
        newU.setPassword(passwordEncoder().encode(user.getPassword()));
        newU.setName(user.getName());
        newU.setSurname(user.getSurname());
        newU.setStatus(Status.ACTIVE);

        return userRepo.save(newU);
    }

    public User getUserById(Long id) {

        String login = userRepo.findById(id).get().getLogin();


        return userRepo.findByLogin(login).orElseThrow(() ->
                new UsernameNotFoundException("User doesn't exists"));
    }

//    public String getUserName(String login) {
//        String firstName = userRepo.findByLogin(login).orElse(null).getName();
//        String lastName = userRepo.findByLogin(login).orElse(null).getSurname();
//        return firstName + " " + lastName;
//    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
