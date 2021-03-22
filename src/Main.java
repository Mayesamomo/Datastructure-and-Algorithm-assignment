
import DSandALGO.HashMap;
import DSandALGO.LinkedList;
import DSandALGO.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import models.PlayList;
import models.Song;
import utils.Commands;
import utils.FileHandler;
import utils.SongComparator.albumComparator;
import utils.SongComparator.artistComparator;
import utils.SongComparator.genreComparator;
import utils.SongComparator.titleComparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author micha
 */
public class Main {

    public static void main(String[] args) {
        FileHandler fileread;
        Commands commands;
        //SongComparator compares = new SongComparator();
        LinkedList list = new LinkedList();
        HashMap map = new HashMap();
        ArrayList<PlayList> play = new ArrayList();
        FileHandler.ReadingFromFile(list, map);
        Stack stack = new Stack();
        ArrayList<Song> songs;
        Scanner sc = new Scanner(System.in);
        FileHandler.ReadingFromFile(play); //reads file 

        /*choices options represented with an integer */
        int[] choice = {-1, 0};
        int[] playlistChoice = {-1, 0};
        //initialize storage variables
        String title = "";//initialize
        String artist = "";//initialize
        String genre = "";//initialize
        String album = "";//initialize
        String PlaylistName = "";//initialize
        int tracknumber = 0;//initialize
        int playcount = 0;//initialize
        double rating = 0;//initialize
        int SongChoice;
        int playlistNameChoice;
        boolean flag = false;
        while (choice[0] != 0) {
            choice = Commands.getMenuChoice(sc);

            switch (choice[0]) {
                case 1://display all
                    switch (choice[1]) {
                        case 1://display by title sort
                            songs = new ArrayList();
                            for (int i = 0; i < list.size(); i++) {
                                songs.add(list.get(i));
                            }
                            System.out.println(map.getValues());

                            Collections.sort(songs, new titleComparator());
                            System.out.println("*******************************************************************");
                            for (Song i : songs) {
                                System.out.println(i);
                            }
                            break;
                        case 2://display by artist sort
                            songs = new ArrayList();

                            for (int i = 0; i < list.size(); i++) {
                                songs.add(list.get(i));
                            }
                            System.out.println(map.getValues());

                            Collections.sort(songs, new artistComparator());
                            System.out.println("***************************************************************************");
                            for (Song i : songs) {
                                System.out.println(i);
                            }
                            break;
                        case 3://display by album sort
                            songs = new ArrayList();

                            for (int i = 0; i < list.size(); i++) {
                                songs.add(list.get(i));
                            }
                            System.out.println(map.getValues());

                            Collections.sort(songs, new albumComparator());
                            System.out.println("***************************************************************************");
                            for (Song i : songs) {
                                System.out.println(i);
                            }
                            break;
                        case 4://display by genre sort
                            songs = new ArrayList();

                            for (int i = 0; i < list.size(); i++) {
                                songs.add(list.get(i));
                            }
                            System.out.println(map.getValues());

                            Collections.sort(songs, new genreComparator());
                            System.out.println("***************************************************************************");
                            for (Song i : songs) {
                                System.out.println(i);
                            }
                            break;
                    }
                    break;
                case 2://add song to the list
                    try {

                        System.out.println("Enter song title");
                        title = sc.next();
                        System.out.println("Enter song Artist");
                        artist = sc.next();
                        System.out.println("Enter song Genre");
                        genre = sc.next();
                        System.out.println("Enter song Album");
                        album = sc.next();
                        System.out.println("Enter song Track Number");
                        tracknumber = sc.nextInt();
                        playcount = 0;
                        System.out.println("Enter song Rating");
                        rating = sc.nextDouble();
                        Song s = new Song(title, artist, genre, album, tracknumber, playcount, rating);
                        list.add(s); //using the linkedList add, add to top of the list
                     
                        map.put(s, s);
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a valid value");
                        sc.nextLine();
                    }
                    break;
                case 3:// remove song
                    System.out.println("Enter song title you want to remove");
                    title = sc.next();
                    System.out.println("Enter song artist you want to remove");
                    artist = sc.next();
                    Song s = new Song(title, artist, "", "", 0, 0, 0);
                    //list.remove(s);
                    if (list.remove(s)) {
                        System.out.println("******************************************************************");
                        System.out.println("Removes Succesfully Song " + s.getTitle());
                        System.out.println("******************************************************************");
                    } else {
                        System.out.println("******************************************************************");
                        System.out.println("Song Not Found To Match title and artist!");
                        System.out.println("******************************************************************");
                    }
                    map.remove(s);
                    break;
                case 4:// searching song
                    switch (choice[1]) {
                        case 1://search by title
                            flag = false;
                            while (flag == false) {
                                System.out.println("Enter a Title to search for Or Type 0 to go back!");
                                title = sc.next();

                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i).getTitle().equalsIgnoreCase(title)) {
                                        System.out.println(list.get(i));
                                        flag = true;
                                    }
                                    if (map.getValues().get(i).getTitle().equalsIgnoreCase(title)) {
                                        System.out.println(map.getValues().get(i));
                                    }
                                    if (title.equalsIgnoreCase("0")) {
                                        flag = true;
                                    }
                                }
                                if (flag == false) {
                                    System.out.println("Song Not Found!");

                                }
                            }
                            break;
                        case 2://search by artist
                            flag = false;
                            while (flag == false) {
                                System.out.println("Enter a Artist to search for Or Type 0 to go back!");
                                artist = sc.next();
                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i).getArtist().equalsIgnoreCase(artist)) {
                                        System.out.println(list.get(i));
                                        flag = true;
                                    }
                                    if (map.getValues().get(i).getArtist().equalsIgnoreCase(artist)) {
                                        System.out.println(map.getValues().get(i));
                                    }
                                    if (artist.equalsIgnoreCase("0")) {
                                        flag = true;
                                    }
                                }
                                if (flag == false) {
                                    System.out.println("Song Not Found!");

                                }
                            }

                            break;
                        case 3://search by album
                            flag = false;
                            while (flag == false) {
                                System.out.println("Enter a Album to search for Or Type 0 to go back!");
                                album = sc.next();
                                for (int i = 0; i < list.size(); i++) {
                                    if (list.get(i).getAlbum().equalsIgnoreCase(album)) {
                                        System.out.println(list.get(i));
                                        flag = true;
                                    }
                                    if (map.getValues().get(i).getAlbum().equalsIgnoreCase(album)) {
                                        System.out.println(map.getValues().get(i));
                                    }
                                    if (album.equalsIgnoreCase("0")) {
                                        flag = true;
                                    }
                                }
                                if (flag == false) {
                                    System.out.println("Song Not Found!");

                                }
                            }
                            break;
                    }
                    break;
                case 5://playlist options
                    playlistChoice = Commands.getPlayListMenuChoice(sc);
                    switch (playlistChoice[0]) {
                        case 1:
                            flag = false;
                            while (flag == false) {
                                System.out.println("Enter Playlist name");
                                PlaylistName = sc.next();

                                for (int i = 0; i < play.size(); i++) {
                                    if (play.get(i).getName().equalsIgnoreCase(PlaylistName)) {
                                        System.out.println("Playlist with the name already exist!");

                                    } else {
                                        System.out.println("playlis Created!");
                                        flag = true;
                                    }
                                }
                            }
                            PlayList pl = new PlayList(PlaylistName);
                            play.add(pl);
                            break;
                        case 2:
                            for (int i = 0; i < play.size(); i++) {
                                System.out.println(play.get(i));
                            }
                            break;
                        case 3:
                            System.out.println("Enter Playlist name");
                            PlaylistName = sc.next();

                            for (int i = 0; i < play.size(); i++) {
                                if (play.get(i).getName().equalsIgnoreCase(PlaylistName)) {
                                    System.out.println(play.get(i));
                                }
                            }
                            break;
                        case 4:
                            switch (playlistChoice[1]) {
                                case 1:
                                    System.out.println("Choose to add song to your playlist");
                                    for (int i = 0; i < play.size(); i++) {
                                        System.out.println(i + ") " + play.get(i).getName());

                                    }
                                    playlistNameChoice = sc.nextInt();
                                    for (int i = 0; i < list.size(); i++) {
                                        System.out.println(i + ") " + list.get(i));
                                    }
                                    SongChoice = sc.nextInt();
                                    Song song = list.get(SongChoice);

                                    stack.push(song);
                                    play.get(playlistNameChoice).setSongs(stack);

                                    break;
                                case 2:
                                    System.out.println("Choose playlist to remove song from");
                                    for (int i = 0; i < play.size(); i++) {
                                        System.out.println(i + ") " + play.get(i).getName());

                                    }
                                    playlistNameChoice = sc.nextInt();
                                    try {
                                        System.out.println("Song Removed : " + play.get(playlistNameChoice).getSongs().pop());
                                    } catch (NullPointerException e) {
                                        System.out.println("Playlist is empty!");
                                    }
                                    break;
                                case 3:
                                    System.out.println("Choose your Playlist");
                                    for (int i = 0; i < play.size(); i++) {
                                        System.out.println(i + ") " + play.get(i).getName());

                                    }
                                    playlistNameChoice = sc.nextInt();
                                    System.out.println("Enter new PlayList Name");
                                    String newName = sc.next();
                                    play.get(playlistNameChoice).setName(newName);
                                    break;
                            }
                            break;
                        case 5:
                            System.out.println("Choose your Playlist");
                            for (int i = 0; i < play.size(); i++) {
                                System.out.println(i + ") " + play.get(i).getName());

                            }
                            playlistNameChoice = sc.nextInt();
                            play.remove(play.get(playlistNameChoice));
                            break;
                    }
                    break;
            }
            if (choice[0] == 0) {
                FileHandler.writeTtoFilePlaylist(play);
                FileHandler.writeTtoFileSong(list);
                System.out.println("GoodBye!");
            }
        }

    }

}
