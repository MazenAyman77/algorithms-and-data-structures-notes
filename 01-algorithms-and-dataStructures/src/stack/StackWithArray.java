package stack;

@SuppressWarnings("unchecked")
public class StackWithArray<T> {

    private final int Max_size = 100;

    private T[] item = (T[]) new Object[Max_size] ;

    // points to the top of the stack
    private int top;

    // number of elements in the stack
    private int size = 0;

    public StackWithArray(){top = -1;}

    public int size(){return size;}

    public boolean isEmpty(){return size == 0;}

    public void push(T element){
        if(top >= Max_size - 1) throw new RuntimeException("Stack is full");
        top ++;
        item[top] = element;
        size ++;
    }

    public T pop(){
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        T element = item[top];
        top --;
        return element;
    }

    public T peek(){
        if(isEmpty()) throw new RuntimeException("Stack is empty");
        return item[top];
    }

    public void print(){
        System.out.print("[");
        for (int i = top; i >= 0; i--){
            System.out.print(item[i] + " ");
        }
        System.out.print("]");
    }

}
