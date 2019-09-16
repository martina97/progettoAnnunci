package boundary;

import bean.TenantAnnounceBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;


public class PostedTenantAnnounceController {


    @FXML
    public Label titleField, nameField, cityField, room, parking, airConditioning, animalsAllowed, garden, wifi, idDateDep, idDateArr, people, bathrooms;


    public void showTenantAnnounce(TenantAnnounceBean bean) throws IOException {

        titleField.setText(bean.getTitle());
        nameField.setText(bean.getName());
        cityField.setText(bean.getCity());
        room.setText(String.valueOf(bean.getRoom()));
        bathrooms.setText(String.valueOf(bean.getBath()));
        people.setText(String.valueOf(bean.getPeople()));
        idDateArr.setText(String.valueOf(bean.getDateArr()));
        idDateDep.setText(String.valueOf(bean.getDateDep()));
        wifi.setText(bean.getWifi());
        garden.setText(bean.getGarden());
        animalsAllowed.setText(bean.getAnimals());
        airConditioning.setText(bean.getAirConditioning());
        parking.setText(bean.getParking());
        
        System.out.println("showTenantAnnounce il bean del title è" + bean.getTitle());


    }



}
