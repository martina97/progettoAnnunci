package boundary;

import bean.TenantAnnounceBean;
import bean.UserBean;
import control.ControllerTenantAnnounce;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class TenantAnnounceUIController {

    @FXML
    public TextField titleField, cityField, room, bathrooms, people;

    @FXML
    public CheckBox wifi, garden, animalsAllowed, airConditioning, parking;

    @FXML
    public DatePicker idDateArr, idDateDep;

    @FXML
    public Button okBtn, deleteBtn, publishBtn;

    @FXML
    public Label nameField;

    //private renterAnnounceBean bean;

    private ControllerTenantAnnounce cta;

    private TenantAnnounceBean bean = new TenantAnnounceBean();


    public void clickedPublishBtn(ActionEvent actionEvent) {


        bean.setTitle(titleField.getText());
        bean.setName(nameField.getText());
        bean.setCity(cityField.getText());
        bean.setRoom(Integer.parseInt(room.getText()));
        bean.setPeople(Integer.parseInt(people.getText()));
        bean.setBath(Integer.parseInt(bathrooms.getText()));

        //data
        bean.setDateArr(idDateArr.getValue());
        bean.setDateDep(idDateDep.getValue());


        if (wifi.isSelected()) {
            bean.setWifi("si");
        } else {
            bean.setWifi("no");
        }

        if (garden.isSelected()) {
            bean.setGarden("si");
        } else {
            bean.setGarden("no");
        }

        if (animalsAllowed.isSelected()) {
            bean.setAnimals("si");
        } else {
            bean.setAnimals("no");
        }

        if (airConditioning.isSelected()) {
            bean.setAirConditioning("si");
        } else {
            bean.setAirConditioning("no");
        }

        if (parking.isSelected()) {
            bean.setParking("si");
        } else {
            bean.setParking("no");
        }



        //una volta inseriti i dati e cliccato su pubblica si chiude la finestra
        Stage stage = (Stage)titleField.getScene().getWindow();
        stage.close();

        cta = ControllerTenantAnnounce.getInstance();
        cta.createTenantAnnounce(bean);
    }


    public int checkDate() {

        System.out.println("oggi è: " + LocalDate.now());

        if (idDateArr.getValue().isBefore(LocalDate.now())) {
            System.out.println("data arr no");
            return 0;
        }

        if (idDateDep.getValue().isBefore(idDateArr.getValue()) || idDateDep.getValue().isEqual(idDateArr.getValue())) {
            System.out.println("data dep no");
            return 1;
        } else {
            System.out.println("data ok");
            return 2;

        }
    }



    public void clickedOkButton(ActionEvent actionEvent) {
        Main notify = new Main();

        if (checkDate() == 0) {
            notify.notification(0, "DATA ERRATA", "Inserisci una data successiva a quella attuale");
        }
        if (checkDate() == 1) {
            notify.notification(0, "DATA ERRATA", "Inserisci una data successiva a quella di arrivo.");
        }
        else if (checkDate() == 2) {
            notify.notification(1, "DATA INSERITA OK", "La data è stata inserita correttamente.");
        }
    }



    public void createStage(UserBean myBean) {
        nameField.setText(myBean.getId());
    }

}