package Socketprogrammiing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client started");
            Socket socket = new Socket("localhost", 9810);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = br.readLine();
            System.out.println("Message received: " + message);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
