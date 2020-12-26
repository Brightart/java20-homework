package game.client;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends Client{
    public static String user_name;
    public static String password;
    public static boolean input = false;
    @FXML
    private Button loginButton;
    @FXML
    private TextField userTextfield;
    @FXML
    private  PasswordField passwordField ;
    
    public void handleLoginAction(){
        user_name = userTextfield.getText();
        password = passwordField.getText();
        input = true;
        try{
        super.connect();
        }catch(Exception e){
            e.printStackTrace();
        }
    }



}