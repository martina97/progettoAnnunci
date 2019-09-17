package boundary;

import bean.UserBean;
import control.ControllerLogin;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginUIController implements Initializable {
    @FXML
    private Button myButton;
    @FXML
    private TextField myTxt;
    @FXML
    private Label lblName;
    @FXML
    private PasswordField myPwd;


    private UserBean bean= new UserBean();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void clickedButton(ActionEvent actionEvent){

        bean.setId(myTxt.textProperty().get());
        bean.setPassword(myPwd.textProperty().get());

        Stage stage = (Stage)myTxt.getScene().getWindow();
        //prendo stage attuale e lo passo come parametro a validateLogin per andare a
        //chiudere lo stage una volta che il login è stato effettuato (quindi verificato).
        //se login non avviene, lo stage non va chiuso perché utente deve reinserire credenziali.


        ControllerLogin cl= ControllerLogin.getInstance();
        cl.validateLogin(bean,stage);



    }
}




