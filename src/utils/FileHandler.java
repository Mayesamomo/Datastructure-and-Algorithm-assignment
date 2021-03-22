/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import DSandALGO.HashMap;
import DSandALGO.LinkedList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import models.PlayList;
import models.Song;

/**
 *
 * @author micha
 */
public class FileHandler {
    //store file path
    private static String filePath = "C:\\Users\\micha\\OneDrive\\Documents\\NetBeansProjects\\FirstCA\\src\\utils\\Songs.txt";
    private static String playlistfile = "C:\\Users\\micha\\OneDrive\\Documents\\NetBeansProjects\\FirstCA\\src\\utils\\Playlist.txt";

    
    //method to read from file and store it using different datastructure
       public static void ReadingFromFile(LinkedList list, HashMap map) {
        Scanner scanner1;
        Scanner scanner2;
        Song song;
        try {
            scanner1 = new Scanner(new File(filePath));
            while (scanner1.hasNext()) { //if there is a character 
                String title = scanner1.next();
                scanner1.next();
                scanner1.next();
                scanner1.next();
                
                String artist = scanner1.next();
                scanner1.next();
                scanner1.next();
                scanner1.next();
                
                String genre = scanner1.next();
                scanner1.next();
                scanner1.next();
                scanner1.next();
                
                String album = scanner1.next();
                scanner1.next();
                scanner1.next();
                scanner1.next();
                
                String trackNumber  = scanner1.next();
                scanner1.next();
                scanner1.next();
                scanner1.next();
                
                String playCount  = scanner1.next();
                scanner1.next();
                scanner1.next();
                scanner1.next();
                
                String rating= scanner1.next();
                song = new Song(title, artist, genre, album, Integer.parseInt(trackNumber), Integer.parseInt(playCount), (int) Double.parseDouble(rating));
                list.add(song); //add to the list 
                map.put(song, song); //save in a map
            }
            scanner1.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

       //read playlist from file
    public static void ReadingFromFile(ArrayList<PlayList> play) {
        Scanner scanner;
        PlayList p;
        try {
            scanner = new Scanner(new File(playlistfile));
            while (scanner.hasNext()) {
                String a = scanner.next();
                p = new PlayList(a);
                play.add(p);

            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

//write playlist to file
    public static void writeTtoFilePlaylist(ArrayList<PlayList> playlist) {
        BufferedWriter outputWriter =null;
        try {
            outputWriter = new BufferedWriter(new FileWriter(playlistfile));
            for (int i = 0; i < playlist.size(); i++) {

                outputWriter.write(playlist.get(i).getName());

                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (IOException e) {
            System.out.println("an exception occur!" +e.getMessage());
        }
    }

    //writes songs to file
    public static void writeTtoFileSong(LinkedList list) {
        BufferedWriter outputWriter;
        try {
            outputWriter = new BufferedWriter(new FileWriter(filePath));
            for (int i = 0; i < list.size(); i++) {

                outputWriter.write(list.get(i) + "");
                outputWriter.newLine();
            }
            outputWriter.flush();
            outputWriter.close();
        } catch (IOException e) {
            System.out.println("an exception occur" + e.getMessage());
        }
    }

    
    
}
