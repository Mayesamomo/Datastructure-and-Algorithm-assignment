/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import DSandALGO.Stack;
import java.util.Objects;

/**
 *
 * @author micha
 */
public class PlayList {
   
  private String name;
    private Stack Songs;

    public PlayList(String name, Stack Songs) {
        this.name = name;
        this.Songs = Songs;
    }
    public PlayList(String name) {
        this.name = name;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stack getSongs() {
        return Songs;
    }

    public void setSongs(Stack Songs) {
        this.Songs = Songs;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.Songs);
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
        final PlayList other = (PlayList) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.Songs, other.Songs);
    }

   

    @Override
    public String toString() {
        return name + " " + Songs ;
    }
    
}
