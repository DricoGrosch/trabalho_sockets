package models;

import java.io.*;
import java.net.Socket;

public class Consumer {
    private String host;
    private int port;
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Consumer(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            this.socket = new Socket(host, port);
            System.out.println("connected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void receiveMessage(String message) {

    }

    public void sendMessage(String message) throws IOException {
        DataOutputStream stream = new DataOutputStream(this.socket.getOutputStream());
        stream.writeBytes(message);
    }
}
