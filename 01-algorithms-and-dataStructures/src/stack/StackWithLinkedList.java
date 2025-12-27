package stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StackWithLinkedList<T> implements Iterable{

    private List<T> list = new LinkedList<>();

    // create an empty stack
    public StackWithLinkedList(){}

    // initialize a stack
    public StackWithLinkedList(T element){
        push(element);
    }

    public int size(){return list.size();}

    public boolean isEmpty(){return list.isEmpty();}

    public void push(T element){
        list.addLast(element);
    }

    public T pop(){
        if(list.isEmpty()) throw new EmptyStackException();
        return list.removeLast();
    }

    public T peek(){
        if(list.isEmpty()) throw new EmptyStackException();
        return list.getLast();
    }

    @Override
    public Iterator iterator() {
        return list.iterator();
    }
}
