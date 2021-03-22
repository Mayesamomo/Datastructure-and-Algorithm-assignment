/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DSandALGO;

import models.Song;

/**
 *
 * @author micha
 */
public class Stack extends LinkedList {

    private int link;
    private Node top;

    public int stackSize() {
        return link;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return link == 0;
    }

    public void push(Object data) {
        Node temp = new Node((Song) data);
        temp.next = temp;
        top = temp;
        link++;
    }

    public Object peek() {
        if (isEmpty()) {
            System.out.println("Empty Playlist");
        }
        return top.data; //check song in a playlist
    }

    //deletes or removes from playlist
    public Object pop() {
        if (isEmpty()) { //if is empty nothing too remove
            System.out.println("Empty Playlist");
        }
        Node node = top;
        top = top.next; //remove from the stack 
        link--; //decrement the stack size
        return node.data;
    }

    @Override
    public String toString() {
        return "links= " + link + ", top= " + top.data;
    }

}
