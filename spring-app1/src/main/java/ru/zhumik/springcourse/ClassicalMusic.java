package ru.zhumik.springcourse;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;

public class ClassicalMusic implements Music {
    @PostConstruct
    public void doMyInit() {
        System.out.println("Doing my initialization");
    }

    @PreDestroy
    public void doMyDestroy() {
        System.out.println("Doing my destruction");
    }

    private List<String> songs = new ArrayList<>();

    {
        songs.add("Hungarian rapsody");
        songs.add("Times of the year");
        songs.add("Shchelkunchik");
    }

    @Override
    public List<String> getSongList() {
        return songs;
    }
}
