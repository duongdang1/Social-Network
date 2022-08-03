package assignment;

public class LinkedQueue<T> implements QueueInterface<T> {
    private Node firstNode;
    private Node lastNode;

    public LinkedQueue(){
        firstNode = null;
        lastNode = null;
    }
    @Override
    public void enqueue(T newEntry) {
        Node newNode = new Node(newEntry);
        if(isEmpty()){
            firstNode = newNode;
        }else{
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
    }

    @Override
    public T dequeue(){
        T front = getFront();
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();
        if(firstNode == null){
            lastNode = null;
        }
        return front;
    }

    @Override
    public T getFront(){
        if(!isEmpty()){
            return firstNode.getData();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (firstNode == null) && (lastNode == null);
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }
    private class Node{
        private T key;
        private Node next;

        public Node(T key) {
            this.key = key;
            this.next = null;
        }

        public void setNextNode(Node next){
            this.next = next;
        }

        public T getData() {
            return key;
        }

        public void setData(T key){
            this.key = key;
        }

        public Node getNextNode(){
            return this.next;
        }
    }
}
