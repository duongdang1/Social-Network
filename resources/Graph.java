package assignment;

import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Queue;

public class Graph<T> implements GraphInterface<T>{
    LinkedListModel<Vertex<T>> graph;

    int edgeNum;
    public Graph(){
        this.graph = new LinkedListModel<>();
        this.edgeNum = 0;
    }
    @Override
    public boolean addVertex(T vertexLabel){
        if(getVertex(vertexLabel) != null){
            return false;
        }
        graph.addLast(new Vertex<T>(vertexLabel));
        return true;
    }

    @Override
    public boolean addEdge(T begin, T end) {
        Vertex<T> be = getVertex(begin);
        Vertex<T> en = getVertex(end);
        edgeNum++;
        return be.connect(en);
    }

    @Override
    public boolean hasEdge(T begin, T end) {
        Vertex<T> be = getVertex(begin);
        Vertex<T> en = getVertex(end);
        return be.isConnect(en);
    }

    @Override
    public boolean isEmpty() {
        return graph.isEmpty();
    }

    @Override
    public int getNumberOfVertices() {
        return graph.size();
    }

    @Override
    public int getNumberOfEdges() {
        return edgeNum;
    }

    @Override
    public void clear() {
        graph.clear();
    }

    @Override
    public Vertex<T> getVertex(T vertexLabel) {
        Vertex<T> vertex;
        Iterator<Vertex<T>> list = graph.iterator();
        while(list.hasNext()){
            vertex = list.next();
            if(vertex.getLabel().equals(vertexLabel)){
                return vertex;
            }
        }
        return null;
    }

    @Override
    public QueueInterface<T> getBreadthFirstTraversal(T origin) {
        QueueInterface<VertexInterface<T>> traversal = new LinkedQueue<>();
        QueueInterface<T> newTraversal = new LinkedQueue<>();
        traversal.enqueue(getVertex(origin));

        QueueInterface<VertexInterface<T>> traversal2 = new LinkedQueue<>();
        traversal2.enqueue(getVertex(origin));
        while(!traversal2.isEmpty()) {
            VertexInterface<T> first = traversal2.dequeue();
            first.unvisit();
            if(first.hasNeighbor()) {
                for (Iterator<VertexInterface<T>> it = first.iterator(); it.hasNext(); ) {
                    VertexInterface<T> neighbor = it.next();
                    if (neighbor.isVisited()) {
                        neighbor.unvisit();
                        traversal2.enqueue(neighbor);
                    }
                }
            }
        }
        while(!traversal.isEmpty()){
            VertexInterface<T> first = traversal.dequeue();
            newTraversal.enqueue(first.getLabel());
            first.visit();
            if(first.hasNeighbor()){
                for (Iterator<VertexInterface<T>> it = first.iterator(); it.hasNext(); ) {
                    VertexInterface<T> neighbor = it.next();
                    if(!neighbor.isVisited()){
                        neighbor.visit();
                        traversal.enqueue(neighbor);
                    }
                }
            }
        }
        return newTraversal;
    }


    public static void main(String[] args) throws Exception {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(3,5);
        graph.addEdge(3,4);
        graph.addEdge(2,4);
        QueueInterface<Integer> queue = graph.getBreadthFirstTraversal(1);
        while(!queue.isEmpty()){
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("\n");
        QueueInterface<Integer> queue1 = graph.getBreadthFirstTraversal(1);
        while(!queue1.isEmpty()){
            System.out.print(queue1.dequeue() + " ");
        }
    }

}
