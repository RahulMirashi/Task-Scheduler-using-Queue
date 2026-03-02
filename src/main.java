
public class MyQueue<T> {

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // front
    private Node tail; // rear
    private int size;

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Add element to rear
    public void enqueue(T item) {

    }

    // Remove element from front
    public T dequeue() {

    }

    // View front element
    public T peek() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}