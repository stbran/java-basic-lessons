package ru.tamno.java.basic.homework11;

public class MyLinkedList<T> {
    class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void print() {
        Node iterator = head;
        while (iterator != null) {
            System.out.println(iterator.data + " ");
            iterator = iterator.next;
        }
    }

    public void addFirst(T data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node tmpHead = head;
            head = node;
            node.next = tmpHead;
        }
    }

    public void addLast(T data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
        } else {
            Node iterator = this.head;
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
        Node iterator = this.head;
        while (iterator.next != null) {
            iterator = iterator.next;
        }
        return iterator.data;
    }

    public int getSize() {
        int size = 0;
        if (this.head != null) {
            Node iterator = this.head;
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
        Node node = new Node(data);
        Node iterator = this.head;
        position--;
        while (iterator.next != null && position > 0) {
            iterator = iterator.next;
            position--;
        }
        Node tmp = iterator.next;
        iterator.next = node;
        node.next = tmp;
    }

    public T remove(int position) {
        if (position >= this.getSize()) {
            System.out.println("No!");
            return null;
        }
        Node tmp;
        if (position == 0) {
            tmp = head;
            head = head.next;
        } else {
            Node iterator = this.head;
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
        Node iterator = this.head;
        while (iterator.next != null && position > 0) {
            iterator = iterator.next;
            position--;
        }
        return iterator.data;
    }
}

