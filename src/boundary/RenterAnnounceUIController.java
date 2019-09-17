package boundary;

import bean.RenterAnnounceBean;
import bean.UserBean;
import control.ControllerRenterAnnounce;
import entity.Apartment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import thread.ListImages;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class RenterAnnounceUIController implements Initializable {

    public Label address;
    public Label description;
    public Label capacity;
    public Label area;
    public AnchorPane ap1;
    public AnchorPane ap2;
    public AnchorPane ap3;
    public AnchorPane ap4;
    public AnchorPane ap5;
    public Label ownerName;

    @FXML
    private TextField title, price;

    @FXML
    private Button publishButton;

    @FXML
    private ImageView image1, image2, image3, image4, image5;

    @FXML
    private Label servicesLabel, dateLabel, priceLabel, peopleLabel, areaLabel, fromLabel, toLabel;

    @FXML
    private CheckBox wifi, animalsAllowed, parking, airConditioning;

    @FXML
    private DatePicker fromDate, toDate;

    private RenterAnnounceBean raBean =new RenterAnnounceBean();
    private UserBean bean = new UserBean();
    private Apartment myApt;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    List<Image> fxImages = new ArrayList<>();

    public void publishButtonClicked(ActionEvent actionEvent) {
        Stage stage = (Stage)title.getScene().getWindow();

        raBean.setTitle(title.getText());
        raBean.setPrice(Float.parseFloat(price.getText()));
        raBean.setFromDate(fromDate.getValue());
        raBean.setToDate(toDate.getValue());
        //bean.setIdOwner(ownerName.getText());

        if (wifi.isSelected()){
            raBean.setWifi("si");
        }
        else{
            raBean.setWifi("no");
        }

        if (animalsAllowed.isSelected()){
            raBean.setAnimals("si");
        }
        else{
            raBean.setAnimals("no");
        }

        if (parking.isSelected()){
            raBean.setParking("si");
        }
        else{
            raBean.setParking("no");
        }

        if (airConditioning.isSelected()){
            raBean.setAirConditioning("si");
        }
        else{
            raBean.setAirConditioning("no");
        }

        raBean.setPictures(fxImages);




        ControllerRenterAnnounce cra= ControllerRenterAnnounce.getInstance();
        System.out.println("sto in Controller");
        cra.validateAnnounce(raBean,myApt,stage,bean);
    }

    //scena su cui inserisco i dati e ci sono già i dati dell'appartamento presi dal DB
    //dati che già ho nel momento in cui vado a cliccare "pubblica"

    public void createStage(Apartment myApartment, UserBean myUserBean) {

        myApt = myApartment;
        address.setText(myApartment.getAddress());
        description.setText(myApartment.getDescription());
        capacity.setText(String.valueOf(myApartment.getCapacity()));
        area.setText(String.valueOf(myApartment.getArea()));
        ownerName.setText(myApartment.getIdOwner());
        address.setText(myApartment.getAddress());
        description.setText(myApartment.getDescription());
        capacity.setText(String.valueOf(myApartment.getCapacity()));
        area.setText(String.valueOf(myApartment.getArea()));



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

        bean = myUserBean;


    }
}
