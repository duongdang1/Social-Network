package assignment;

import java.util.Iterator;

/*
    An Interface that describes the operations of a LinkedList
     */
public interface LinkedListInterface<T> {
    /*
    Get the current number of entries in the LinkedList
     */

    int size();

    /*
    check whether the LinkedList is empty
     */
    boolean isEmpty();

    /*
    add an Entry to the beginning of the list
     */
    void addFirst(T entry);

    /*
    add an Entry to the last of the list
     */
    void addLast(T entry);

    /*
    Iterate the link list
     */
    Iterator<T> iterator();

    /*
    check whether an Entry is in the LinkedList;
     */
    boolean contains(T entry);

    /*
    get node
     */
    T get(T entry);

    /**
     * clear the linkedlist
     */

    void clear();

}
