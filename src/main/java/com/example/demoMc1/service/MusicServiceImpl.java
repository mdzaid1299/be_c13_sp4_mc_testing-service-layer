package com.example.demoMc1.service;

import com.example.demoMc1.domain.Music;
import com.example.demoMc1.exception.MusicAlreadyExistException;
import com.example.demoMc1.exception.MusicNotFound;
import com.example.demoMc1.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService{

    MusicRepository musicRepository;
    public MusicServiceImpl(MusicRepository musicRepository){
        this.musicRepository = musicRepository;
    }

    @Override
    public Music saveMusic(Music music) throws MusicAlreadyExistException {
        if(musicRepository.findById(music.getTrackId()).isPresent())
        {
            throw new MusicAlreadyExistException();
        }
        return musicRepository.save(music);

    }

    @Override
    public List<Music> getAllMusicData() throws MusicNotFound {
        return musicRepository.findAll();
    }

    @Override
    public boolean deleteMusic(int trackId) throws MusicNotFound {
        boolean result = false;
        if(musicRepository.findById(trackId).isEmpty()){
            throw new MusicNotFound();
        }else{
            musicRepository.deleteById(trackId);
            result = true;
        }
        return result;
    }


    @Override
    public List<Music> getAllMusicByTrackRating(int trackRating) throws MusicNotFound {
        if(musicRepository.findAllMusicFromTrackRating(trackRating).isEmpty()){
            throw  new MusicNotFound();
        }
        return musicRepository.findAllMusicFromTrackRating(trackRating);
    }

    @Override
    public List<Music> getAllMusicByArtistName(String artistName) throws MusicNotFound {
        if(musicRepository.findAllMusicFromArtistName(artistName).isEmpty()){
            throw  new MusicNotFound();
        }
        return musicRepository.findAllMusicFromArtistName(artistName);
    }
}
