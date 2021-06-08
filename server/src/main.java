import models.Server;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws IOException, ScriptException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Wish port would you like to star the server ?");
        Server server = new Server(scan.nextInt());
//        Server server = new Server(8000);
    }
}
