package models;

import com.sun.xml.internal.ws.util.StringUtils;
import models.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    PrintStream ps;

    public Server(int port) throws IOException, ScriptException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Waiting connections");
        Socket s = ss.accept();
        System.out.println("Connection established");
        this.ps
                = new PrintStream(s.getOutputStream());
        BufferedReader br
                = new BufferedReader(
                new InputStreamReader(
                        s.getInputStream()));

        this.ps.println("Connection established");
        while (true) {
            String str;
            while ((str = br.readLine()) != null) {
                this.handleMessage(str);
            }

            br.close();
            ss.close();
            s.close();
            System.exit(0);

        }
    }

    public void handleMessage(String message) throws ScriptException {
        String[] query = message.split(";");
        HashMap<String, String> params = new HashMap<>();
        for (String param : query) {
            params.put(param.split("=")[0], param.split("=")[1]);
        }
        switch (params.get("model")) {

            case "student": {
                new Student().dispatchOperation(params, this.ps);
            }
            case "teacher": {
                break;

            }
            case "classroom": {
                break;

            }
        }
    }
}
