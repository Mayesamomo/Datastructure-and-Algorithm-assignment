/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSandALGO;

import java.util.ArrayList;
import java.util.List;
import models.Song;

/**
 *
 * @author micha
 */
public class HashMap {

    private Entry[] map; // Declare an array of Entry objects to store key-value pairs
    private int count;

    public HashMap() {
        map = new Entry[100];
    }

    private void addToMap() {
        Entry[] tempMap = new Entry[map.length * 2];
    }

    private int generateSlot(Song key) {
        // number represenation
        Song s = new Song(key.getTitle(), key.getArtist(), "", "", 0, 0, 0);
        int hash = Math.abs(s.hashCode());
        //slot for the has number
        int slot = hash % map.length;
        return slot;
    }

    public Song put(Song key, Song value) {

        int destination = generateSlot(key);
        if (map[destination] == null) {
            Entry newEntry = new Entry(key, value);
            map[destination] = newEntry;
            count++;
            return null;
        } else {

            Song oldValue = map[destination].value;
            map[destination].value = value;
            return oldValue;

        }

    }

    public Song remove(Song key) {
        int slot = generateSlot(key);
        if (map[slot] != null) {
            Song oldValue = map[slot].value;
            map[slot] = null;
            count--;
            return oldValue;
        } else {
            return null;
        }
    }

    public int size() {
        return count;
    }

    public boolean containKey(Song key) {
        int slot = generateSlot(key);
        if (map[slot] == null) {
            return false;
        } else {
            return true;
        }
    }

    public Song get(Song key) {
        int slot = generateSlot(key);
        if (map[slot] != null) {
            return map[slot].value;
        } else {
            return null;
        }
    }

    public List<Song> getKeys() {
        List<Song> keys = new ArrayList();
        for (int i = 0; i < map.length; i++) {
            if (map[i] != null) {
                keys.add(map[i].key);
            }
        }
        return keys;
    }

    public List<Song> getValues() {
        List<Song> values = new ArrayList();
        for (int i = 0; i < map.length; i++) {
            if (map[i] != null) {
                values.add(map[i].value);
            }
        }
        return values;
    }

    private static class Entry {

        private Song key;
        private Song value;

        public Entry(Song key, Song value) {
            this.key = key;
            this.value = value;
        }
    }


}
