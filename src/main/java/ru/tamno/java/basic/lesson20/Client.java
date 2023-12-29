package ru.tamno.java.basic.lesson20;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите пример для решения, используя числа и знаки действия +,-,* или /.\n" +
                "Например: 5+6");
        byte[] lineToServer = sc.next().getBytes();
        socket.getOutputStream().write(lineToServer);
        socket.getOutputStream().flush();
        byte[] lineFromServer = new byte[100];
        socket.getInputStream().read(lineFromServer);
        System.out.println("Ответ: " + new String(lineFromServer).trim());
    }
}
