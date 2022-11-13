package com.example.demoMc1.service;

import com.example.demoMc1.domain.Music;
import com.example.demoMc1.exception.MusicAlreadyExistException;
import com.example.demoMc1.exception.MusicNotFound;

import java.util.List;

public interface MusicService {
    Music saveMusic(Music music) throws MusicAlreadyExistException;
    List<Music> getAllMusicData() throws MusicNotFound;
    public boolean deleteMusic(int trackId) throws MusicNotFound;
    List<Music> getAllMusicByTrackRating(int trackRating) throws MusicNotFound;
    List<Music> getAllMusicByArtistName(String artistName) throws MusicNotFound;
}
