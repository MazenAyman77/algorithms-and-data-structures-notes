package dynamicarray;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private T[] array;
    private int length =0; // length user think array is
    private int capacity; // the actual array size

    public DynamicArray(){
        capacity = 16;
    }

    public DynamicArray(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("Illegal capacity : " + capacity);
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public int size(){return length;}

    public boolean isEmpty(){return length == 0 ;}

    public T get(int index){return array[index];}

    public void set(int index, T element){
        array[index] = element;
    }

    public void clear(){
        for(int i = 0; i < length; i++) array[i] = null;
        length = 0;
    }

    public void add(T element){
        if(length +1 > capacity){
            if(capacity == 0) capacity = 1;
            else{
//                capacity *=2;
//                T[] newArr = (T[]) new Object[capacity];
//                for(int i = 0; i < length; i++){
//                    newArr[i] = array[i];
//                }
//                array = newArr;
                array = Arrays.copyOf(array, capacity);
            }
        }
        array[length++] = element;
    }

    public T removesAt(int index){
        if(index >= length || index < 0) throw new IndexOutOfBoundsException();
        T data = array[index];
        T[] newArr = (T[]) new Object[length - 1];
        for(int i=0, j=0; i<length; i++, j++){ // i is for the old array, j is for the new array
            if(i == index) j--; // here we skip the index of the element we want to remove and adjusting js
            else newArr[j] = array[i];
        }
        array = newArr;
        capacity = --length;
        return data;
    }

    public int indexOf(Object object){
        for(int i = 0; i < length; i++){
            if(object == null){
                if(array[i] == null) return i;
            }else{
                if(array[i].equals(object)) return i;
            }
        }
        return -1;
    }

    public boolean remove(Object object){
        int index = indexOf(object);
        if(index == -1) return false;
        removesAt(index);
        return true;
    }

    public boolean contains(Object object){
        return indexOf(object) != -1;
    }

    // Iterator is still fast but not as fast as iterative for loop
    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public T next() {
                return array[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        if (length == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(length).append("[");
            for (int i = 0; i < length - 1; i++) sb.append(array[i] + ", ");
            return sb.append(array[length - 1] + "]").toString();
        }
    }

}
