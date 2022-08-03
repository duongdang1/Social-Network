package assignment;
import java.util.Iterator;
/**
 An interface for a vertex in a graph.
 @author Frank M. Carrano
 @version 4.0
 */
public interface VertexInterface<T>
{
    /** Gets this vertexÕs label.
     @return the object that labels the vertex */
    public T getLabel();
    public int getNumberOfNeighbors();
    /** Marks this vertex as visited. */
    public void visit();
    /** Removes this vertexÕs visited mark. */
    public void unvisit();
    /** Sees whether the vertex is marked as visited.
     @return true if the vertex is visited */
    public boolean isVisited();
    /** Connects this vertex and a given vertex with a weighted edge.
     The two vertices cannot be the same, and must not already
     have this edge between them. In a directed graph, the edge
     points toward the given vertex.
     @param endVertex a vertex in the graph that ends the edge
     @param edgeWeight a real-valued edge weight, if any
     @return true if the edge is added, or false if not */

    /** Connects this vertex and a given vertex with an unweighted
     edge. The two vertices cannot be the same, and must not
     already have this edge between them. In a directed graph,
     the edge points toward the given vertex.
     @param endVertex a vertex in the graph that ends the edge
     @return true if the edge is added, or false if not */
    public boolean connect(VertexInterface<T> endVertex);

    /** Sees whether this vertex has at least one neighbor.
     @return true if the vertex has a neighbor */
    public boolean hasNeighbor();

    public Iterator<VertexInterface<T>> iterator();


} // end VertexInterface