package queue;

@SuppressWarnings("unchecked")
public class ArrayQueue<T> {

    private int size = 0; // the number of data in the array
    private int front = 0; // the index of the front element of the array
    private int rear = 0; // the index of the last element of the array
    private T[] array;

    public ArrayQueue(){}

    public ArrayQueue(int capacity){
        if(capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        array = (T[]) new Object[capacity];
    }

    public int size(){return size;}

    public boolean isEmpty(){return size == 0;}

    public boolean isFull(){return size == array.length;}

    public void enqueue(T element){
        if(isFull()) throw new IllegalStateException("Queue is full");
        array[rear] = element;
        rear = (rear + 1) % array.length; // here we move forward the index of the last element and check if its at the end of the array or not
        size ++;
    }

    public T dequeue(){
        if(isEmpty()) throw new IllegalStateException("Queue is empty");
        T data = array[front];
        array[front] = null; // here we are deallocating the front element of the queue and the garbage collector will remove it from memory
        front = (front + 1) % array.length; // here we move forward the index of the first element and check if its at the end of the array or not
        size --;
        return data;
    }

    public T peek(){
        if(isEmpty()) throw new IllegalStateException("Queue is empty");
        return array[front];
    }

}
