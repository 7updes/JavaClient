package network;

import java.io.*;
import java.net.Socket;
import java.util.Timer;

/**
 * Created by Alex on 07.05.2015.
 */


public class MyClient {

    private String host;
    private int port;

    public MyClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private BufferedReader inu = null;

    public  void execute()  {

        Socket fromServer = null;
        BufferedReader in = null;
        PrintWriter out = null;
        Request request = null;

        System.out.println("Welcome to Client side");

        try {
            fromServer = new Socket(host, port);
        System.out.println("Connected to server successful!");
            in = new BufferedReader(new InputStreamReader(fromServer.getInputStream()));
            out = new PrintWriter(fromServer.getOutputStream(), true);
            inu = new BufferedReader(new InputStreamReader(System.in));
            String fuser, fserver = null;

            System.out.println("Type something...\nclose and exit - means end of connection");
            while (true) {
                fuser = inu.readLine();
                if (fuser.equalsIgnoreCase("close") || fuser.equalsIgnoreCase("exit")) {
                    break;
                } else if(fuser.equals("ping")){
                    if (!Ping.check(host)) {
                        break;
                    }
                }
                if(request == null) {
                    request = new Request(fserver, fuser, out, in);
                    request.setDaemon(true);
                    request.start();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
                inu.close();
                in.close();
                fromServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
