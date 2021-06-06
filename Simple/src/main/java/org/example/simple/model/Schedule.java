package org.example.simple.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "begin_time"/*, columnDefinition = "datetime"*/)
    private LocalTime beginTime;
    @Column(name = "end_time")
    private LocalTime endTime;

    @JsonIgnore
    @OneToMany(mappedBy = "schedule")
    private List<User> users;
}