package boundary;

import bean.RenterAnnounceBean;
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
    public AnchorPane ap1, ap2, ap3, ap4, ap5;
    public ImageView image1, image2, image3, image4, image5;

    List<Image> fxImages = new ArrayList<>();

    public void showRenterAnnounce(RenterAnnounceBean bean) throws IOException  {

        System.out.println("id è " + bean.getIdApt());
        System.out.println("addresso "+ bean.getAddress());
        System.out.println("descr" + bean.getDescription());
        System.out.println("capacity" + bean.getCapacity());
        System.out.println("area" + bean.getArea());
        System.out.println("price "+ bean.getPrice());
        System.out.println("from" + bean.getFromDate());
        System.out.println("to "+ bean.getToDate());
        System.out.println("title" + bean.getTitle());
        System.out.println("wifi" + bean.getWifi());
        System.out.println("animals" + bean.getAnimals());
        System.out.println("parking" + bean.getParking());
        System.out.println("air" + bean.getAirConditioning());


        address.setText(bean.getAddress());
        description.setText(bean.getDescription());

        capacity.setText(String.valueOf(bean.getCapacity()));
        area.setText(String.valueOf(bean.getArea()));
        from.setText(String.valueOf(bean.getFromDate()));
        to.setText(String.valueOf(bean.getToDate()));
        wifi.setText(bean.getWifi());
        pets.setText(bean.getAnimals());
        air.setText(bean.getAirConditioning());
        price.setText(String.valueOf(bean.getPrice()));
        title.setText(bean.getTitle());
        parking.setText(bean.getParking());

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



    }

    public void clickedBackButton(ActionEvent actionEvent) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/Menu.fxml"));
            Stage stage = (Stage)area.getScene().getWindow();
            stage.setScene(new Scene(loader.load()));

            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}