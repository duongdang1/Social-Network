package assignment;

import java.util.Iterator;

public class LinkedListModel<T> implements LinkedListInterface<T> {
    private Node firstNode;
    private int numberOfEntries;
    public LinkedListModel(){
        initializeDataFields();
    }

    private void initializeDataFields(){
        firstNode = null;
        numberOfEntries = 0;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void addFirst(T entry) {
        Node newNode = new Node(entry,firstNode);
        firstNode = newNode;
        numberOfEntries++;
    }

    @Override
    public void addLast(T entry) {
        Node newNode = firstNode;
        Node lastNode = new Node(entry,null);
        if(isEmpty()){
            firstNode = lastNode;
        }else{
            while(newNode.getNext()!= null){
                newNode = newNode.getNext();
            }
            newNode.setNext(lastNode);
        }
        ++ numberOfEntries;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node current = firstNode;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = (T) current.data;
                    current = current.getNext();
                    return data;
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }

        };

    }

    @Override
    public boolean contains(T entry) {
        Node first = firstNode;
        while(first != null){
            if(first.getData() == entry){
                return true;
            }
            first = first.getNext();
        }
        return false;
    }

    @Override
    public T get(T entry){
        Node first = firstNode;
        while(first != null){
            if(first.getData() == entry){
                return (T) first;
            }
            first = first.getNext();
        }
        return null;
    }

    @Override
    public void clear() {
        firstNode = null;
    }


    // Node class: Should be private so not written in Javadoc format
    // A class that represents a Node with a data of type generic and
    // a Node type next link
    private class Node<T> {
        private T data;
        private Node next;



        // private constructor of class DoublyLinkedNode with a data, nextNode and previousNode parameters
        private Node(T data, Node next){
            this.data = data;
            this.next = next;

        }
        // get and set methods for DoublyLinkedNode class


        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }


    }
}
