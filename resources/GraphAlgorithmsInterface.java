package assignment;

import java.util.Queue;
import java.util.Stack;

/**
 An interface of methods that process an existing graph.
 @author Frank M. Carrano
 @version 4.0
 */
public interface GraphAlgorithmsInterface<T>
{
    /** Performs a breadth-first traversal of a graph.
     @param origin an object that labels the origin vertex of the
     traversal
     @return a queue of labels of the vertices in the traversal, with
     the label of the origin vertex at the queueÕs front */
    public QueueInterface<T> getBreadthFirstTraversal(T origin) throws Exception;


} // end GraphAlgorithmsInterface
