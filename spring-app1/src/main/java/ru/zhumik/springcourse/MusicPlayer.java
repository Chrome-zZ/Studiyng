package ru.zhumik.springcourse;


import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Random;

public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    private List<Music> musicList;

    public MusicPlayer(List<Music> musicList){
        this.musicList = musicList;
    }

    public String playMusic() {
        Random random = new Random();

        int randomNumber = random.nextInt(3);
        return "Playing: " + musicList.get(random.nextInt(musicList.size()))
                .getSongList().get(randomNumber);
    }
}
