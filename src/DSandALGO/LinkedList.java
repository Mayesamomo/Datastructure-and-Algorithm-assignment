package DSandALGO;

import java.util.Iterator;
import java.util.NoSuchElementException;
import models.Song;

/**
 * ;
 *
 * @author michelle
 */
public class LinkedList implements Iterable {
protected Node first;
    protected int size;
    

        
    public LinkedList() {
        first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }
// starting time 
        long start = System.currentTimeMillis();
    public void add(Song data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node current = first;
            while (current.hasNext()) {
                current = current.next;
            }
            current.next = newNode;
        }
         // ending time 
        long end = System.currentTimeMillis(); 
        size++;
    }

    public boolean remove(Song s) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node current = first;
        while (current.next != null) {
            if (current.next.data.equals(s)) {
                current.next = current.next.next;
                size--;
                return true;
            } else {
                current = current.next;
            }
        }
        return false;
    }

    public Song get(int pos) {
        if (isEmpty() || pos >= size || pos < 0) {
            throw new IndexOutOfBoundsException();
        } else if (pos == 0) {
            return first.data;
        } else {
            Node current = first;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    public int size() {
        return size;
    }

    protected static class Node {

        protected Song data;
        protected Node next;

        public Node(Song data) {
            next = null;
            this.data = data;
        }

        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", next=" + next + '}';
        }

    }

    @Override
    public Iterator iterator() {
        return new LinkListIterator();
    }

    private class LinkListIterator implements Iterator {

        private int nextIndex;
        private Node last;
        private Node next;

        public LinkListIterator() {
            next = first;
            last = null;
            nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            last = next;
            next = next.next;
            nextIndex++;
            return last.data;
        }
    }
}
