package com.example.demoMc1.service;

import com.example.demoMc1.domain.Artist;
import com.example.demoMc1.domain.Music;
import com.example.demoMc1.exception.MusicAlreadyExistException;
import com.example.demoMc1.exception.MusicNotFound;
import com.example.demoMc1.repository.MusicRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @Mock
    private MusicRepository musicRepository;

    @InjectMocks
    private MusicServiceImpl musicService;
    private Music music1,music2;
    List<Music> musicList;
    Artist artist1, artist2;
    @BeforeEach
    void setUp() {
        artist1 = new Artist(20,"RKK");
         music1 = new Music(29,"mana ki",4,artist1);
        artist2 = new Artist(25,"arijit");
        music2 = new Music(29,"mahi ve",4,artist2);
        musicList= Arrays.asList(music1,music2);
    }

    @Test
    public void givenMusicToSaveReturnSavedMusicSuccess() throws MusicAlreadyExistException {
        when(musicRepository.save(any())).thenReturn(music1);
        when(musicRepository.findById(music1.getTrackId())).thenReturn(Optional.ofNullable(null));

        assertEquals(music1,musicService.saveMusic(music1));
        verify(musicRepository,times(1)).save(any());
        verify(musicRepository,times(1)).findById(any());
    }



    @Test
    public void givenMusicToSaveReturnMusicFailure(){
        when(musicRepository.findById(music1.getTrackId())).thenReturn(Optional.ofNullable(music1));
        assertThrows(MusicAlreadyExistException.class,()->musicService.saveMusic(music1));
        verify(musicRepository,times(0)).save(any());
        verify(musicRepository,times(1)).findById(any());
    }

    @Test
    public void givenMusicToDeleteShouldDeleteSuccess() throws MusicNotFound {
        when(musicRepository.findById(music1.getTrackId())).thenReturn(Optional.ofNullable(music1));
        boolean flag = musicService.deleteMusic(music1.getTrackId());
        assertEquals(true,flag);

        verify(musicRepository,times(1)).deleteById(any());
        verify(musicRepository,times(1)).findById(any());
    }




}
