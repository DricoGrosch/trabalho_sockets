package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Consumer {
    private String host;
    private int port;

    public Consumer(String host, int port) {
        this.host = host;
        this.port = port;
        try (Socket s = new Socket(host, port);) {
            System.out.println("connected");
            InputStream input = s.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
