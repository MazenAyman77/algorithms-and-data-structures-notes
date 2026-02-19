package priorityqueue;

import java.util.*;

// the types of elements I allow inside my priority queue have to be comparable elements
// like strings integers anything with comparable interface
public class PriorityQueue <T extends Comparable<T>>{

    // number of elements inside the heap
    private int heapSize = 0;
    // the actual size of the heap
    private int heapCapacity = 0;
    private List<T> heap = null;

    // for the log(n) removals, we keep track using this map
    private Map<T, TreeSet<Integer>> map = new HashMap<>();

    public PriorityQueue(){
        this(1);
    }

    public PriorityQueue(int size) {
        heap = new ArrayList<>(size);
    }

//    public PriorityQueue(Collection<T> elements){
//        this(elements.size());
//        for(T element : elements) add(element);
//    }
//
//    public void add(){
//
//    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    public void clear(){
        for(int i = 0; i < heapSize; i++){
            heap.set(i, null);
        }
        heapSize = 0;
        map.clear();
    }

    public int size(){return heapSize;}

    // returns the value of the element with the lowest priority in the queue
    public T peek(){
        if(isEmpty()){
            return null;
        }
        return heap.getFirst();
    }

    // removes the root of the heap
//    public T poll(){
//        return removeAt(0);
//    }

//    public T removeAt(){
//
//    }

    public boolean contains(T element){
        // map lookup O(1)
        if(element == null) return false;
        return map.containsKey(element);

        // linear lookup O(n)
//        for(int i = 0; i < heapSize; i++){
//            if(heap.get(i) == element){
//                return true
//            }
//        }
//        return false;
    }

    




}
