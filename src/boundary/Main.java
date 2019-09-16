package boundary;

import control.ControllerLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import jdk.jshell.ImportSnippet;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("RenterAnnounceUI.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("TenantAnnounce.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 500, 290));
        primaryStage.show();
/*

        String imgUrl = "images/image.jpg";
        Image image = new Image(imgUrl, 600,300,false,true);

        ImageView imageView = new ImageView(image);
        HBox root = new HBox();
        root.getChildren().add(imageView);
        // Set the padding of the HBox
        root.setStyle("-fx-padding: 10;");
        // Set the border-style of the HBox
        root.setStyle("-fx-border-style: solid inside;");
        // Set the border-width of the HBox
        root.setStyle("-fx-border-width: 2;");
        // Set the border-insets of the HBox
        root.setStyle("-fx-border-insets: 5;");
        // Set the border-radius of the HBox
        root.setStyle("-fx-border-radius: 5;");
        // Set the border-color of the HBox
        root.setStyle("-fx-border-color: blue;");
        // Set the size of the HBox
        root.setPrefSize(600, 300);

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the scene to the Stage
        primaryStage.setScene(scene);
        // Set the title of the Stage
        primaryStage.setTitle("Displaying an Image");
        // Display the Stage
        primaryStage.show();
        */
    }

    public void notification (int type, String title, String msg) {

        TrayNotification tray = new TrayNotification();
        AnimationType t = AnimationType.POPUP;
        tray.setAnimationType(t);
        tray.setTitle(title);
        tray.setMessage(msg);
        tray.showAndDismiss(Duration.seconds(3));
        if (type == 1) {
            tray.setNotificationType(NotificationType.SUCCESS);
        }
        else if (type == 0) {
            tray.setNotificationType(NotificationType.ERROR);

        }
    }



    public static void main(String[] args) {

        launch(args);

    }
}
