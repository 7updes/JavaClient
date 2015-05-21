package main;

import network.MyClient;

/**
 * Created by Alex on 11.05.2015.
 */
public class App {
    public static void main(String[] args) {
        MyClient client = new MyClient(args[0], Integer.valueOf(args[1]));
        client.execute();
    }
}
