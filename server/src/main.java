
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wish port would you like to star the server ?");
        int port = scan.nextInt();
        ServerSocket ss = new ServerSocket(888);

        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");

        PrintStream ps
                = new PrintStream(s.getOutputStream());

        BufferedReader br
                = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()));

        while (true) {
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            ps.close();
            br.close();
            ss.close();
            s.close();
            System.exit(0);

        }
    }
}
