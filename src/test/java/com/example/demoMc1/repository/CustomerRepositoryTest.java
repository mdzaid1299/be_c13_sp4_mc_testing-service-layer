package com.example.demoMc1.repository;

import com.example.demoMc1.domain.Artist;
import com.example.demoMc1.domain.Music;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomerRepositoryTest {
    @Autowired
    private MusicRepository musicRepository;
    private Artist artist;
    private Music music;
    @BeforeEach
    public void setUp(){
       artist = new Artist(11,"KK");
       music = new Music(12,"bulleya",4,artist);

    }



    @AfterEach
    public void tearDown(){
        artist = null;
        music = null;
       // musicRepository.deleteAll();
    }
    @Test
    @DisplayName("Test case for saving music object")
    void givenMusicToSaveShouldReturnSavedMusic(){
        musicRepository.save(music);
        Music music1 = musicRepository.findById(music.getTrackId()).get();
        assertNotNull(music1);
        assertEquals(music.getTrackId(),music1.getTrackId());
    }

    @Test
    @DisplayName("Test case for deleting music object")
    public void givenMusicToDeleteShouldDeleteMusic() {
        // customerRepository.insert(customer);
        Music music1 = musicRepository.findById(music.getTrackId()).get();
        musicRepository.delete(music1);
        assertEquals(Optional.empty(),  musicRepository.findById(music.getTrackId()));

    }
    @Test
    @DisplayName("Test case for retrieving all the  music object")
    public void givenMusicReturnAllMusicDetails() {

        //customerRepository.insert(customer);
      Artist  artist1 = new Artist(15,"Kumar sanu");
      Music  music1 = new Music(19,"channa ve",4,artist);
        musicRepository.insert(music1);

        List<Music> list = musicRepository.findAll();
        assertEquals(8, list.size());
        assertEquals("channa ve", list.get(1).getTrackName());

    }
}
