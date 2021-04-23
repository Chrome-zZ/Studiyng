package ru.zhumik.springcourse;

import java.util.ArrayList;
import java.util.List;

public class JazzMusic implements Music {
    private List<String> songs = new ArrayList<>();

    {
        songs.add("Sad nigga");
        songs.add("Very sad nigga");
        songs.add("Black nigger");
    }

    @Override
    public List<String> getSongList() {
        return songs;
    }
}
