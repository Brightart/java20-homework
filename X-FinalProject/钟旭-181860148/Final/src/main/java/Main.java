
import game.server.*;
public class Main {
    public static void main(String[] args) {
        try{
            Server server = new Server();
            server.on();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}