package boundary;

import bean.RenterAnnounceBean;
import bean.UserBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import thread.ListImages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PostedRenterAnnounceController {

    @FXML
    public Label address, description, ownerName, capacity, area, from, to, wifi, pets, parking, air, title, price;

    @FXML
    public AnchorPane ap1, ap2, ap3, ap4, ap5;

    @FXML
    public ImageView image1, image2, image3, image4, image5;

    @FXML
    public Button backBtn;

    private UserBean userBean = new UserBean();

    List<Image> fxImages = new ArrayList<>();
    Stage stage;

    public void showRenterAnnounce(RenterAnnounceBean raBean, UserBean myBean,Stage myStage) throws IOException  {

        System.out.println("id è " + raBean.getIdApt());
        System.out.println("addresso "+ raBean.getAddress());
        System.out.println("descr" + raBean.getDescription());
        System.out.println("capacity" + raBean.getCapacity());
        System.out.println("area" + raBean.getArea());
        System.out.println("price "+ raBean.getPrice());
        System.out.println("from" + raBean.getFromDate());
        System.out.println("to "+ raBean.getToDate());
        System.out.println("title" + raBean.getTitle());
        System.out.println("wifi" + raBean.getWifi());
        System.out.println("animals" + raBean.getAnimals());
        System.out.println("parking" + raBean.getParking());
        System.out.println("air" + raBean.getAirConditioning());


        address.setText(raBean.getAddress());
        description.setText(raBean.getDescription());

        capacity.setText(String.valueOf(raBean.getCapacity()));
        area.setText(String.valueOf(raBean.getArea()));
        from.setText(String.valueOf(raBean.getFromDate()));
        to.setText(String.valueOf(raBean.getToDate()));
        wifi.setText(raBean.getWifi());
        pets.setText(raBean.getAnimals());
        air.setText(raBean.getAirConditioning());
        price.setText(String.valueOf(raBean.getPrice()));
        title.setText(raBean.getTitle());
        parking.setText(raBean.getParking());

        ListImages myListImages=new ListImages();
        fxImages=myListImages.loadImageList();

        image1.setImage(fxImages.get(0));
        image2.setImage(fxImages.get(1));
        image3.setImage(fxImages.get(2));
        image4.setImage(fxImages.get(3));
        image5.setImage(fxImages.get(4));


        image1.fitWidthProperty().bind(ap1.widthProperty());
        image1.fitHeightProperty().bind(ap1.heightProperty());
        image1.setPreserveRatio(false);

        image2.fitWidthProperty().bind(ap2.widthProperty());
        image2.fitHeightProperty().bind(ap2.heightProperty());
        image2.setPreserveRatio(false);

        image3.fitWidthProperty().bind(ap2.widthProperty());
        image3.fitHeightProperty().bind(ap2.heightProperty());
        image3.setPreserveRatio(false);

        image4.fitWidthProperty().bind(ap2.widthProperty());
        image4.fitHeightProperty().bind(ap2.heightProperty());
        image4.setPreserveRatio(false);

        image5.fitWidthProperty().bind(ap2.widthProperty());
        image5.fitHeightProperty().bind(ap2.heightProperty());
        image5.setPreserveRatio(false);

        userBean = myBean;
        stage = myStage;
    }

    public void clickedBackButton(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Menu.fxml"));
            Parent root = loader.load();
            MenuController controller = loader.getController();
            System.out.println("prima di createStage");
            controller.createStage(userBean);
            System.out.println("dopo di createStage");
            Scene scene = new Scene(root);

            /*
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Menu");
            primaryStage.setScene(scene);

            primaryStage.show();
            */

            stage.setTitle("Menu");
            stage.setScene(scene);

            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}