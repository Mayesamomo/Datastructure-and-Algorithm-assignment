/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author micha
 */
public class Song  implements Comparable<Song> {
    private String title;
    private String artist;
    private String genre;
    private String album;
    private int trackNumber;
    private int playCount;
    private double rating;
   
    
    public Song() {
    }

    public Song(String title, String artist, String genre, String album, int trackNumber, int playCount, double rating) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
        this.trackNumber = trackNumber;
        this.playCount = playCount;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public int getPlayCount() {
        return playCount;
    }

    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.title);
        hash = 79 * hash + Objects.hashCode(this.artist);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Song other = (Song) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return Objects.equals(this.artist, other.artist);
    }

   
    

  

    @Override
    public String toString() {
         return "Title : " + title + " \n"
                + "Artist : "+ artist+" \n" 
                + "Genre : " + genre+ " \n" 
                + "Album : " + album+ " \n" 
                + "TrackNum : " + trackNumber+ " \n" 
                + "PlayCount : " + playCount+ " \n"
                + "Rating : " + rating+ " \n"  ;
    }

    
    @Override
    public int compareTo(Song s ) {
        if (this.title.equalsIgnoreCase(s.title)) {
            return 0;
        } else if (this.artist.equalsIgnoreCase(s.artist)) {
            return 1;
        } else {
            return -1;
        }
    }

    
}
