package assignment;
/**
 An interface of methods providing basic operations for directed
 and undirected graphs that are either weighted or unweighted.
 @author Frank M. Carrano
 @version 4.0
 */
public interface BasicGraphInterface<T>
{
    /** Adds a given vertex to this graph.
     @param vertexLabel an object that labels the new vertex and is
     distinct from the labels of current vertices
     @return true if the vertex is added, or false if not */
    public boolean addVertex(T vertexLabel);

    /** Adds an unweighted edge between two given distinct vertices
     that are currently in this graph. The desired edge must not
     already be in the graph. In a directed graph, the edge points
     toward the second vertex given.
     @param begin an object that labels the origin vertex of the edge
     @param end an object, distinct from begin, that labels the end
     vertex of the edge
     @return true if the edge is added, or false if not */
    public boolean addEdge(T begin, T end);
    /** Sees whether an edge exists between two given vertices.
     @param begin an object that labels the origin vertex of the edge
     @param end an object that labels the end vertex of the edge
     @return true if an edge exists */
    public boolean hasEdge(T begin, T end);
    /** Sees whether this graph is empty.
     @return true if the graph is empty */
    public boolean isEmpty();
    /** Gets the number of vertices in this graph.
     @return the number of vertices in the graph */
    public int getNumberOfVertices();
    /** Gets the number of edges in this graph.
     @return the number of edges in the graph */
    public int getNumberOfEdges();
    /** Removes all vertices and edges from this graph. */
    public void clear();

    /**
     * get vertex
     */
    public Vertex<T> getVertex(T vertexLabel);
} // end BasicGraphInterface
