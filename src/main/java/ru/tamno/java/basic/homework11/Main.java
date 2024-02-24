package ru.tamno.java.basic.homework11;

//import static ru.tamno.java.basic.homework11.Sorting.quickSort;
import static ru.tamno.java.basic.homework11.Sorting.sort;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10 + 1);
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        sort(arr);
//        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


        MyLinkedList<Integer> ll = new MyLinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.print();
        ll.addFirst(0);
        ll.print();
        System.out.println("getFirst - " + ll.getFirst());
        System.out.println("getLast - " + ll.getLast());
        System.out.println("getSize - " + ll.getSize());
        ll.add(2, 10);
        ll.print();
        System.out.println("remove - " + ll.remove(2));
        ll.print();
        System.out.println("get - " + ll.get(4));

        MyQueue<String> mq = new MyQueue<>();
        mq.offer("a");
        mq.offer("b");
        mq.offer("c");
        mq.poll();
        mq.poll();
        mq.print();

        MyStack<Integer> ms = new MyStack<>();
        ms.push(1);
        ms.push(2);
        ms.push(3);
        ms.pop();
        ms.pop();
        ms.print();
    }
}
