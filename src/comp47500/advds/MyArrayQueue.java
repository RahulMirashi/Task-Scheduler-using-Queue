package comp47500.advds;

import java.util.NoSuchElementException;

public class MyArrayQueue<T> {

    private T[] data;
    private int front;
    private int rear;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyArrayQueue() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = 0;
        size = 0;
    }

    public void enqueue(T item) {
        if (size == data.length) {
            resize(data.length * 2);
        }

        data[rear] = item;
        rear = (rear + 1) % data.length;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        T item = data[front];
        data[front] = null; // help GC
        front = (front + 1) % data.length;
        size--;

        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }

        data = newData;
        front = 0;
        rear = size;
    }
}