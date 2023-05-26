package Socketprogrammiing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servers {
    public static void main(String[] args) {
        try {
            System.out.println("Server start");
            ServerSocket serverSocket = new ServerSocket(9810);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection established...");

                // Create a new thread for each client connection
                Handler clientHandler = new Handler(clientSocket);
                clientHandler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}