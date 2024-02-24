package ru.tamno.java.basic.homework11;

public class MyQueue<T> {
    private MyLinkedList<T> queue;

    public MyQueue() {
        this.queue = new MyLinkedList<>();
    }

    public void offer(T data) {
        queue.addLast(data);
    }

    public T poll() {
        if (queue.getSize() == 0) {
            return null;
        }
        T tmp = (T) queue.getFirst();
        queue.remove(0);
        return tmp;
    }

    public void print() {
        queue.print();
    }
}
