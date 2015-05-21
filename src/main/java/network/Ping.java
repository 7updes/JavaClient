package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Alex on 07.05.2015.
 */
public class Ping {

    public static boolean check(String host){

        InetAddress inet;

        try {
            inet = InetAddress.getByName(host);
            System.out.println("Sending Ping Request to " + host);
            boolean reach = inet.isReachable(5000);
            System.out.println(reach ? "Host is reachable" : "Host is NOT reachable");
            Thread.sleep(1000);
            return reach;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
