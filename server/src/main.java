import models.Server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class main {
    public static void main(String[] args) throws IOException {
        Server server = new Server(8000);
        server.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                try {
                    server.stop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
    }
}
