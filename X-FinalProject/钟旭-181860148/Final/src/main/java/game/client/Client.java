package game.client;


import java.net.*;

import game.Common;
import game.Message;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;


import java.io.*;



public class Client extends Application{
    Socket socket = null;
    boolean state = false;

    ObjectInputStream in = null;
    ObjectOutputStream out = null;



    @Override
    public void start(Stage stage){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/resources/LOGIN.fxml"));
            stage.setTitle("Battle");
            stage.setScene(new Scene(root));
            stage.show();
           
        }catch(Exception e){
            e.printStackTrace();
        }
    
    }

    public  void connect() throws Exception{
        socket = new Socket("localhost",Common.PORT);
        System.out.println("1");
        
        if(LoginController.input==true){
           
            Message loginMessage = new Message();
            loginMessage.model = "login";
            loginMessage.content1 = LoginController.user_name;
            loginMessage.content2 = LoginController.password;
            this.out = new ObjectOutputStream(socket.getOutputStream());
        
            this.out.writeObject(loginMessage);
        
            LoginController.input = false;

            this.in = new ObjectInputStream(socket.getInputStream());
          
            while(true){
                Message rec_message = (Message)this.in.readObject();
                System.out.println(rec_message);
         
                if(rec_message.model.equals("login")){
                    if(rec_message.content1.equals("true")){
                        this.state = true;
                        System.out.print("login succeed.");
                    }
                }
                else{

                }
        }
        
    }
    }
    public static void main(String[] args) {
    
        launch();
        
    }
  
}
