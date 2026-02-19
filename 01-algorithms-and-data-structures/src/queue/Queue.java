package queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable{

    private LinkedList<T> list = new LinkedList<>();

    // creating an empty queue
    public Queue(){}

    public Queue(T element){
        enqueue(element);
    }

    public int size(){return list.size();}

    public boolean isEmpty(){return list.isEmpty();}

    public void enqueue(T element){
        list.addLast(element);
    }

    public T dequeue(){
        if(list.isEmpty()) throw new RuntimeException("Queue is empty");
        return list.removeFirst();
    }

    public T peek(){
        if(list.isEmpty()) throw new RuntimeException("Queue is empty");
        return list.getFirst();
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }
}
