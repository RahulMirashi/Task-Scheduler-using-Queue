 class MyQueue<T> {

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
        Node newNode = new Node(item);

        if (tail != null) {
            tail.next = newNode;
        }

        tail = newNode;
        //queue is empty before adding new node
        if (head == null) {
            head = tail;
        }

        size++;
    }

    // Remove element from front
    public T dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }

        T data = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        size--;
        return data;
    }

    // View front element
    public T peek() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        return head.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}