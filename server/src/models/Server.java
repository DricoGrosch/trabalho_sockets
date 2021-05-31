package models;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket;

    public Server(int port) throws IOException {
        this.serverSocket = new ServerSocket(8000);
        serverSocket.setReuseAddress(true);
    }

    public void start() {
        while (true) {
            System.out.println("waiting connection");
            try (Socket s = serverSocket.accept()) {
                System.out.println("connected with " + s.getInetAddress().getHostAddress());
                OutputStream out = s.getOutputStream();
                String response = "it worked";
                out.write(response.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() throws IOException {
        this.serverSocket.close();
    }
}
