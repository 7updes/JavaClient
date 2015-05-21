package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * Created by Alex on 20.05.2015.
 */
public class Request extends Thread {

    private String fserver;
    private String fuser;
    private PrintWriter out;
    private BufferedReader in;

    public Request(String fserver, String fuser, PrintWriter out, BufferedReader in) {
        this.fserver = fserver;
        this.fuser = fuser;
        this.out = out;
        this.in = in;
    }

    @Override
    public void run() {
        while(true){
            out.println(fuser);
            try {
                while ((fserver = in.readLine()) != null) {
                    if(fserver.equalsIgnoreCase("exit")){
                        break;
                    }
                    System.out.println(fserver);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
