import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class main {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        server.setReuseAddress(true);

        while (true) {
            System.out.println("waiting connection");
            try (Socket s = server.accept()) {
                System.out.println("connected with " + s.getInetAddress().getHostAddress());
                OutputStream out = s.getOutputStream();
                String response = "it worked";
                out.write(response.getBytes());
            }
        }
    }
}
