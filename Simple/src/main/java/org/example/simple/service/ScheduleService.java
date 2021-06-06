package org.example.simple.service;

import org.example.simple.dto.ScheduleDTO;
import org.example.simple.model.Schedule;
import org.example.simple.model.User;
import org.example.simple.repo.ScheduleRepo;
import org.example.simple.repo.UserRepo;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepo scheduleRepo;
    private final UserRepo userRepo;

    public ScheduleService(ScheduleRepo scheduleRepo, UserRepo userRepo) {
        this.scheduleRepo = scheduleRepo;
        this.userRepo = userRepo;
    }

    public Schedule addSchedule(Schedule schedule) {
        Schedule newSchedule = new Schedule();
        List<User> users = userRepo.findAll();
        newSchedule.setBeginTime(schedule.getBeginTime());
        newSchedule.setEndTime(schedule.getEndTime());
        newSchedule.setUsers(users);
        return scheduleRepo.save(newSchedule);
    }

    public void addUserInSchedule(ScheduleDTO scheduleDTO) {
        User userToAdd = userRepo.findById(scheduleDTO.getUserId()).orElseThrow(()
                -> new UsernameNotFoundException("User doesn't exists"));
        Schedule schedule = scheduleRepo.findById(scheduleDTO.getScheduleId()).orElseThrow(()
                -> new UsernameNotFoundException("Schedule doesn't exists"));
        List<User> users = new ArrayList<>();
        users.add(userToAdd);
        schedule.setUsers(users);
    }

    public Iterable<Schedule> getSchedules() {
        return scheduleRepo.findAll();
    }

    public Schedule getScheduleById(Long id) {
        return scheduleRepo.getOne(id);
    }
//        return userRepo.findByLogin(login).orElseThrow(() ->
//                new UsernameNotFoundException("User doesn't exists"));

//    public Schedule getScheduleByUserName(String userName) {
//        Schedule scheduleByName = null;
//        for (Schedule schedule : getSchedules()) {
//            if (schedule.getUsers().stream().findFirst().equals(userName)) {
//                scheduleByName = schedule;
//            }
//        }
//        return scheduleByName;
//    }
}