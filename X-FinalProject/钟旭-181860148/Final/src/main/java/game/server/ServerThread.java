package game.server;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import game.Message;

public class ServerThread implements Runnable{
    Socket l_socket;
    ObjectInputStream in = null;
    ObjectOutputStream out = null;
    ServerThread(Socket s){
        l_socket = s;
        try{
            in = new ObjectInputStream(l_socket.getInputStream());
            out = new ObjectOutputStream(l_socket.getOutputStream());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void run(){
        try{
            while(true){
                System.out.println("-1001");
                Message message =(Message)this.in.readObject();
                System.out.println(message);
                if(message.model.equals("login")){
                    if(true){
                        message.content1 = "true";
                        message.content2 = null;
                        System.out.println("x");
                        this.out.writeObject(message);
                        System.out.println("y");
                    }
                   
                }
                else{

                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}