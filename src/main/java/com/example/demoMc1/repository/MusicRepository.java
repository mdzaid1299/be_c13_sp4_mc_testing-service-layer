package com.example.demoMc1.repository;

import com.example.demoMc1.domain.Music;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends MongoRepository<Music,Integer> {
    @Query("{'trackRating':{ $gt: 4}}")
    List<Music> findAllMusicFromTrackRating(int trackRating);
    @Query("{'artist.artistName':{$in:[?0]}}")
    List<Music> findAllMusicFromArtistName(String artistName);

}

