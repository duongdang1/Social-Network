package assignment;
/**
 An interface of methods that create, manipulate, and process a graph.
 @author Frank M. Carrano
 @version 4.0
 */
public interface GraphInterface<T> extends BasicGraphInterface<T>,
        GraphAlgorithmsInterface<T>

{
    public QueueInterface<T> getBreadthFirstTraversal(T origin) ;

} // end GraphInterface
