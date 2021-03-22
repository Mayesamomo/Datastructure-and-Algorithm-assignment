/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Comparator;
import models.Song;

/**
 *
 * @author micha
 */
public class SongComparator {
     public static class titleComparator implements Comparator<Song> {

        @Override
        public int compare(Song s1, Song s2) {
            return s1.getTitle().compareTo(s2.getTitle());
        }
    }

    public static class artistComparator implements Comparator<Song> {

        @Override
        public int compare(Song s1, Song s2) {
            return s1.getArtist().compareTo(s2.getArtist());
        }
    }

    public static class albumComparator implements Comparator<Song> {

        @Override
        public int compare(Song s1, Song s2) {
            return s1.getAlbum().compareTo(s2.getAlbum());
        }
    }

    public static class genreComparator implements Comparator<Song> {

        @Override
        public int compare(Song s1, Song s2) {
            return s1.getGenre().compareTo(s2.getGenre());
        }
    }
}
