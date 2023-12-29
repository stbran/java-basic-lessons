package ru.tamno.java.basic.lesson20;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            byte[] op = new byte[100];
            socket.getInputStream().read(op);
            String rawStr = new String(op).trim();
            System.out.println(rawStr);
            String action = action(rawStr);
            socket.getOutputStream().write(action.getBytes());
            socket.getOutputStream().flush();
            if (action.contains("Illegal")) {
                System.out.println(action);
                break;
            }
        }
    }

    private static String action(String rawStr) {
        String action = null;
        if (!(rawStr.contains("+") || rawStr.contains("-") || rawStr.contains("/") || rawStr.contains("*"))) {
            action = "Illegal action. Good Bye";
        } else {
            String[] actionComponents;
            int responce = 0;
            if (rawStr.contains("+")) {
                actionComponents = rawStr.split("\\+");
                responce = Integer.parseInt(actionComponents[0]) + Integer.parseInt(actionComponents[1]);
            }
            if (rawStr.contains("-")) {
                actionComponents = rawStr.split("-");
                responce = Integer.parseInt(actionComponents[0]) - Integer.parseInt(actionComponents[1]);
            }
            if (rawStr.contains("/")) {
                actionComponents = rawStr.split("/");
                responce = Integer.parseInt(actionComponents[0]) / Integer.parseInt(actionComponents[1]);
            }
            if (rawStr.contains("*")) {
                actionComponents = rawStr.split("\\*");
                responce = Integer.parseInt(actionComponents[0]) * Integer.parseInt(actionComponents[1]);
            }
            action = String.valueOf(responce);
        }
        return action;
    }
}
