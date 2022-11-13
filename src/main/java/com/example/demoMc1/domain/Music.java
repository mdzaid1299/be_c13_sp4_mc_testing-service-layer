package com.example.demoMc1.domain;

public class Music {
    private int trackId;
    private String trackName;
    private int trackRating;
    private Artist artist;

    public Music(int trackId, String trackName, int trackRating, Artist artist) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.trackRating = trackRating;
        this.artist = artist;
    }

    public Music() {
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public int getTrackRating() {
        return trackRating;
    }

    public void setTrackRating(int trackRating) {
        this.trackRating = trackRating;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Music{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", trackRating=" + trackRating +
                ", artist=" + artist +
                '}';
    }
}
