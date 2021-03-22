/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author micha
 */
public class Commands {
    //commands gets PlayList MENU
        public static int[] getPlayListMenuChoice(Scanner sc) {
        System.out.println("***************************************************************");
        int choice[] = {-1, 0};
        while (choice[0] < 0) {
            System.out.println("please select what to do");
            System.out.println("0) Exit Application");
            System.out.println("1) Create a Custom Playlist");
            System.out.println("2) Display list Of Playlist");
            System.out.println("3) Display Specific Playlsit");
            System.out.println("4) Edit Playlist");
            System.out.println("5) Delete a Playlist");
            System.out.println("***************************************************************");
            try {
                choice[0] = sc.nextInt();

                switch (choice[0]) {
                    case 4:
                        System.out.println("1)Add a song to playList");
                        System.out.println("2)Remove Song from playlist");
                        System.out.println("3)rename Playlist");
                        choice[1] = sc.nextInt();
                        break;
                }

            } catch (InputMismatchException ex) {
                System.out.println("Please enter a corresponding Number" +ex.getMessage());
                sc.nextLine();
            }

        }
        return choice;
    }
        
    //commands gets menu's choices
            public static int[] getMenuChoice(Scanner sc) {
        System.out.println("***************************************************************");
        int[] choice = {-1, 0};
        while (choice[0] < 0) {
            System.out.println("please select what to do");
            System.out.println("0) Exit Application");
            System.out.println("1) Display All Songs");
            System.out.println("2) Add Song");
            System.out.println("3) Delete Song");
            System.out.println("4) Search Song");
            System.out.println("5) PlayList");
            System.out.println("***************************************************************");
            try {
                choice[0] = sc.nextInt();
                switch (choice[0]) {
                    case 1:
                        System.out.println("Select How to Order Songs");
                        System.out.println("1) Title");
                        System.out.println("2) Artist");
                        System.out.println("3) Album");
                        System.out.println("4) Genre");
                        choice[1] = sc.nextInt();
                        return choice;
                    case 4:
                        System.out.println("Select How you want to search");
                        System.out.println("1) Title ");
                        System.out.println("2) Artist");
                        System.out.println("3) Album");
                        choice[1] = sc.nextInt();
                        return choice;

                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a corresponding Number" +ex.getMessage());
                sc.nextLine();
            }

        }
        return choice;
    }

            
}
