package ru.tamno.java.basic.homework11;

public class MyStack<T> {
    private MyLinkedList stack;

    public MyStack() {
        this.stack = new MyLinkedList();
    }

    public T push(T data) {
        stack.addFirst(data);
        return (T) stack.getFirst();
    }

    public T pop() {
        if (stack.getSize() == 0) {
            return null;
        }
        T tmp = (T) stack.getFirst();
        stack.remove(0);
        return tmp;
    }

    public void print() {
        stack.print();
    }
}
