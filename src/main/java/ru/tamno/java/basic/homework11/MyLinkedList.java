package ru.tamno.java.basic.homework11;

public class MyLinkedList<T> {
    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;

    public void print() {
        Node<T> iterator = head;
        while (iterator != null) {
            System.out.println(iterator.data + " ");
            iterator = iterator.next;
        }
    }

    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node<T> tmpHead = head;
            head = node;
            node.next = tmpHead;
        }
    }

    public void addLast(T data) {
        Node<T> node = new Node<>(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node<T> iterator = this.head;
            while (iterator.next != null) {
                iterator = iterator.next;
            }
            iterator.next = node;
        }
    }

    public T getFirst() {
        if (this.head == null) {
            return null;
        }
        return head.data;
    }

    public T getLast() {
        if (this.head == null) {
            return null;
        }
        Node<T> iterator = this.head;
        while (iterator.next != null) {
            iterator = iterator.next;
        }
        return iterator.data;
    }

    public int getSize() {
        int size = 0;
        if (this.head != null) {
            Node<T> iterator = this.head;
            size = 1;
            while (iterator.next != null) {
                iterator = iterator.next;
                size++;
            }
        }
        return size;
    }

    public void add(int position, T data) {
        if (position >= this.getSize()) {
            System.out.println("No!");
            return;
        }
        if (position == 0) {
            addFirst(data);
            return;
        }
        Node<T> node = new Node<>(data);
        Node<T> iterator = this.head;
        position--;
        while (iterator.next != null && position > 0) {
            iterator = iterator.next;
            position--;
        }
        Node<T> tmp = iterator.next;
        iterator.next = node;
        node.next = tmp;
    }

    public T remove(int position) {
        if (position >= this.getSize()) {
            System.out.println("No!");
            return null;
        }
        Node<T> tmp;
        if (position == 0) {
            tmp = head;
            head = head.next;
        } else {
            Node<T> iterator = this.head;
            position--;
            while (iterator.next != null && position > 0) {
                iterator = iterator.next;
                position--;
            }
            tmp = iterator.next;
            iterator.next = iterator.next.next;
        }
        return tmp.data;
    }

    public T get(int position) {
        if (position >= this.getSize()) {
            System.out.println("No!");
            return null;
        }
        if (position == 0) {
            return head.data;
        }
        Node<T> iterator = this.head;
        while (iterator.next != null && position > 0) {
            iterator = iterator.next;
            position--;
        }
        return iterator.data;
    }
}

