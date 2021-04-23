package ru.zhumik.springcourse;

import java.util.ArrayList;
import java.util.List;

public class RockMusic implements Music {
    private List<String> songs = new ArrayList<>();

    {
        songs.add("Wind cries Mary");
        songs.add("Sum 41");
        songs.add("Blink 182");
    }

    @Override
    public List<String> getSongList() {
        return songs;
    }
}
