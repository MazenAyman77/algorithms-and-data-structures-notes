package linkedlist;

import java.util.Iterator;

public class DoublyLinkedList <T> implements Iterable {

    // linked lists contains nodes
    private static class Node <T>{
        T data; // the item in the list
        Node<T> prev, next; // pointers to the previous and next node
        public Node (T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }

    private int size = 0; // size of the linked list
    private Node<T> head = null; // first node in the list
    private Node<T> tail = null; // last node in the list

    // method to clear all nodes in the linked list
    public void clear() {
        Node<T> trav = head;
        while (trav != null) {
            Node<T> node = trav.next;
            trav.prev = trav.next = null;
            trav.data = null;
            trav = node;
        }
        head = tail = null;
        size = 0;
    }

    // to know the size of the linked list
    public int size(){
        return size;
    }

    // to add data to the linked list, adding it in the ends usually
    public void add(T element){
        addLast(element);
    }

    // to know if is the list is empty or not
    public boolean isEmpty(){
        return size == 0 ;
    }

    // to add data in the beginning of the list
    public void addFirst(T element){
        if(isEmpty()){
            head = tail = new Node<T>(element, null, null);
        }else{
            head.prev = new Node<T>(element, null, head);
            head = head.prev;
        }
        size ++;
    }

    // to add data in the ending of the list
    public void addLast(T element){
        if(isEmpty()){
            head = tail = new Node<T>(element, null, null);
        }else{
            tail.next = new Node<T>(element, tail, null);
            tail = tail.next;
        }
        size ++;
    }

    // to know the first data of the list
    public T peekFirst(){
        if(isEmpty()) throw new RuntimeException("The list is empty");
        return head.data;
    }

    // to know the last data in the list
    public T peekLast(){
        if(isEmpty()) throw new RuntimeException("The list is empty");
        return tail.data;
    }

    // to remove the first data in the list
    public T removeFirst(){
        if(isEmpty()) throw new RuntimeException("The list is empty");
        T data = head.data;
        head = head.next;
        -- size;
        if(isEmpty()) tail = null;
        else head.prev = null;
        return data;
    }

    // to remove the last data in the list
    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("Empty List");
        T data = tail.data;
        tail = tail.prev;
        -- size;
        if(isEmpty()) head = null;
        else tail.next = null;
        return data;
    }

    // to remove a particular node in the list
    private T removeNode(Node<T> node){
        if(node.prev == null) return removeFirst(); // means the node is at the head of the list
        if(node.next == null) return removeLast(); // means the node is at the tail of the list

        T data = node.data;

        node.next.prev = node.prev;
        node.prev.next = node.next;

        node.data = null;
        node = node.prev = node.next = null;
        -- size;

        return data;
    }

    // to remove a particular index
    public T removesAt(int index){
        if(index < 0 || index >= size) throw new IndexOutOfBoundsException("Index is wrong");
        int i;
        Node<T> trav; // pointer
        if(index < size/2){
            // search from the beginning of the list
            for(i = 0, trav = head; i != index; i++){
                trav = trav.next;
            }
        }else{
            for(i = size - 1, trav = tail; i != index; i--){
                trav = trav.prev;
            }
        }
        return removeNode(trav);
    }

    // to remove a particular data
    public boolean removeData(Object object){
        Node<T> trav;
        if(object == null){
            for(trav = head; trav != null; trav = trav.next){
                if(trav.data == null){
                    removeNode(trav);
                    return true;
                }
            }
        }else{
            for(trav = head; trav != null; trav = trav.next){
                if(object.equals(trav.data)){
                    removeNode(trav);
                    return true;
                }
            }
        }
        return false;
    }

    // to get the index of a particular data
    public int indexOfData(Object object){
        int index = 0;
        Node<T> trav;

        if(object == null){
            for(trav = head; trav != null; trav = trav.next, index++){
                if(trav.data == null) return index;
            }
        }else{
            for(trav = head; trav != null; trav = trav.next, index++){
                if(object.equals(trav.data)) return index;
            }
        }
        return -1;
    }

    // to check if the list has a particular data
    public boolean contains(Object object){
        return indexOfData(object) != -1;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            private Node<T> trav = head;

            @Override
            public boolean hasNext() {
                return trav != null;
            }

            @Override
            public T next() {
                T data = trav.data;
                trav = trav.next;
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> trav = head;
        while (trav != null) {
            sb.append(trav.data);
            if (trav.next != null) {
                sb.append(", ");
            }
            trav = trav.next;
        }
        sb.append(" ]");
        return sb.toString();
    }
}
