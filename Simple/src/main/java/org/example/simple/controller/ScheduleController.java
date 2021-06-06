package org.example.simple.controller;

import org.example.simple.dto.ScheduleDTO;
import org.example.simple.model.Schedule;
import org.example.simple.service.ScheduleService;
import org.example.simple.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final UserService userService;


    public ScheduleController(ScheduleService scheduleService, UserService userService) {
        this.scheduleService = scheduleService;
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('read')")
    public Iterable<Schedule> getSchedules() {
        return scheduleService.getSchedules();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('write')")
    public Schedule addSchedule(@RequestBody Schedule schedule) {

        return scheduleService.addSchedule(schedule);
    }

    @PostMapping("/user_add")
    @PreAuthorize("hasAuthority('write')")
    public void addPeopleInSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        scheduleService.addUserInSchedule(scheduleDTO);
    }
//    public void addPeopleInSchedule(@PathVariable Long userId,
//                                    @PathVariable Long scheduleId) {
//        scheduleService.addUserInSchedule(userId, scheduleId);
//    }
}