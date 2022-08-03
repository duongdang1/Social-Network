package assignment;

import java.util.Iterator;
//import java.util.LinkedList;

public class Vertex<T> implements VertexInterface<T>{
    T lable;
    boolean visited;
    LinkedListModel<VertexInterface<T>> neighbor;
    public Vertex(T label){
        visited = false;
        this.lable = label;
        neighbor = new LinkedListModel<>();
    }
    @Override
    public T getLabel() {
        return lable;
    }

    @Override
    public int getNumberOfNeighbors() {
        return neighbor.size();
    }

    @Override
    public void visit() {
        visited = true;
    }

    @Override
    public void unvisit() {
        visited = false;
    }

    @Override
    public boolean isVisited() {
        return visited;
    }


    @Override
    public boolean connect(VertexInterface<T> endVertex) {
        if(neighbor.contains(endVertex)){
            return false;
        }
        this.neighbor.addLast(endVertex);
        return true;
    }

    public boolean isConnect(VertexInterface<T> endVertex){
        return neighbor.contains(endVertex);
    }
    @Override
    public boolean hasNeighbor() {
        return !neighbor.isEmpty();
    }

    public Iterator<VertexInterface<T>> iterator(){
        return neighbor.iterator();
    }
}
