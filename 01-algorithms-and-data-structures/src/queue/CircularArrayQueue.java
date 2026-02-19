package queue;

public class CircularArrayQueue<T> {

    private int front;
    private int rear;
    private int size;
    private final int maxSize;
    private final T[] array;

    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int size) {
        if (size <= 0) throw new IllegalArgumentException("Capacity must be positive");

        this.maxSize = size;
        this.array = (T[]) new Object[maxSize];
        this.front = 0;
        this.rear = maxSize - 1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public int size() {
        return size;
    }

    public void enqueue(T element) {
        if (isFull())
            throw new IllegalStateException("Queue is full");

        rear = (rear + 1) % maxSize;
        array[rear] = element;
        size++;
    }

    public T dequeue() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");

        T element = array[front];
        array[front] = null; // avoid memory leaks
        front = (front + 1) % maxSize;
        size--;
        return element;
    }

    public T peekFront() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        return array[front];
    }

    public T peekRear() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        return array[rear];
    }

    public int search(T element) {
        int pos = -1;

        if (!isEmpty()) {
            int i = front;
            while (i != rear) {
                if (array[i] == element) {
                    pos = i;
                    break;
                }
                i = (i + 1) % maxSize;
            }
            if (pos == -1 && array[rear] == element)
                pos = rear;
        } else {
            System.out.println("Q is empty !");
        }
        return pos;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Empty Queue");
        }
        else{
            while(front != rear){
                System.out.println(array[front]);
                front = (front + 1) % maxSize;
            }
            System.out.println(array[rear]);
        }
    }
}
