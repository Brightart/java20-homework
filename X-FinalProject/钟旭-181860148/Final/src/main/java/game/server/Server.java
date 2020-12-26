package game.server;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import game.Common;

public class Server {
    ServerSocket serversocket = null;
    ObjectInputStream in = null;
    ObjectOutputStream out = null;

    public void on()throws Exception{
        serversocket = new ServerSocket(Common.PORT);
        System.out.println("-999");
        Socket s = serversocket.accept();
        System.out.println("-1000");
        ServerThread server = new ServerThread(s);
        server.run();
    }

    
}