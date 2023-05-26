package Socketprogrammiing;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Handler extends Thread {
    private final Socket clientSocket;

    public Handler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            PrintStream ps = new PrintStream(clientSocket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter message to be sent:");
            String message = scanner.nextLine();
            ps.print(message);

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
