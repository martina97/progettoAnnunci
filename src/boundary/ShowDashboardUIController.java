package boundary;

import bean.RenterAnnounceBean;
import bean.TenantAnnounceBean;
import bean.UserBean;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowDashboardUIController {

    public ListView listViewTenant;
    public ListView listViewRenter;
    public Button okBtn;

    public ArrayList<RenterAnnounceBean> rList;

    public ArrayList<TenantAnnounceBean> tList;

    UserBean bean = new UserBean();
    //ControllerShowDashboard myController;

    Stage stage;
/*
    public void ShowDashboardUIController(ControllerShowDashboard controller) {

        this.myController = controller;
    } */

    public void clickedOkBtn(ActionEvent actionEvent) {

        //quando premo ok chiamo funzione del control createListApartments ch emi restituisce le due iste di bean
        //quando premo ok a seconda se ho scelto un ann di renter o tenant vado nel template e non devo fare più niente perchè gia passo un bran!
        //PROBLEMA : come faccio a sapere da quale lista lo prendo??????
        //se non selezioni niente da una lista allora avrai selezionato dall'altra (controllo gli indici oppure i nomi selezionati, se uno è null allora l'avrò preso dall'altra lista
        int renterIndex = listViewRenter.getSelectionModel().getSelectedIndex();
        int tenantIndex = listViewTenant.getSelectionModel().getSelectedIndex();

        System.out.println("indice renter selezionato" + renterIndex);
        System.out.println("indice tenant selezionato" + tenantIndex);


        //SELEZIONE ANNUNCIO AFFITTASI (RENTER)

        //OK
        if (renterIndex >0  && tenantIndex <= 0 ) {

            //abbiamo selezionato l'annuncio renter
            try {

                System.out.println("stage è ]]]]]]]]]]]]]]]]]]]]]]]]]]]]" + stage);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/PostedRenterAnnounce.fxml"));
                Parent root = loader.load();
                PostedRenterAnnounceController controller = loader.getController();
                controller.showRenterAnnounce(rList.get(renterIndex-1),bean,stage);
                Scene scene = new Scene(root);

               // Stage primaryStage = new Stage();
                stage.setTitle("Annuncio Affittasi");
                stage.setScene(scene);

                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }

       }

        if (tenantIndex >0  && renterIndex <= 0 ) {

            //abbiamo selezionato l'annuncio tenant
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/PostedTenantAnnounce.fxml"));
                Parent root = loader.load();
                PostedTenantAnnounceController controller = loader.getController();
                controller.showTenantAnnounce(tList.get(tenantIndex-1));
                Scene scene = new Scene(root);

                Stage primaryStage = new Stage();
                primaryStage.setTitle("Annuncio Cercasi");
                primaryStage.setScene(scene);

                primaryStage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        //ERRORE: nessun annuncio selezionato, selezionane uno
        if (renterIndex<=0 && tenantIndex<=0){
            Main notify= new Main();
            notify.notification(0,"ERRORE NELLA SELEZIONE","Non hai selezionato nessun annuncio.");
        }

        //ERRORE: due annunci selezionati, selezionane SOLO uno
        if (renterIndex>0 && tenantIndex>0){
            Main notify= new Main();
            notify.notification(0,"ERRORE NELLA SELEZIONE","Hai selezionato due annunci, scegline uno.");

        }
    }


    public void createListViewAnnounces(ArrayList<RenterAnnounceBean> renterList, ArrayList<TenantAnnounceBean> tenantList, UserBean myBean,Stage myStage) {


        //RENTER
        ArrayList<String> announcesRenterList = new ArrayList<>();
        announcesRenterList.add("---Nessuno---");


        for (int i=0; i < renterList.size(); i++) {
            announcesRenterList.add(renterList.get(i).getTitle());
        }

        System.out.println("annRentList[0] =  " + announcesRenterList.get(0));
        System.out.println("annRentList[1] =  " + announcesRenterList.get(1));
        System.out.println("annRentList[2] =  " + announcesRenterList.get(2));
        //System.out.println("annRentList[17] =  " + announcesRenterList.get(17));


        ObservableList<String> listViewRenterElements = FXCollections.observableList(announcesRenterList);
        listViewRenter.setItems(listViewRenterElements);



       //TENANT
        ArrayList<String> announcesTenantList = new ArrayList<>();
        announcesTenantList.add("---Nessuno---");

        for (int i=0; i < tenantList.size(); i++) {
            announcesTenantList.add(tenantList.get(i).getTitle());
        }


        ObservableList<String> listViewTenantElements = FXCollections.observableList(announcesTenantList);
        listViewTenant.setItems(listViewTenantElements);


        rList = renterList;
        tList = tenantList;

        bean = myBean;
        stage = myStage;
        System.out.println("stage1 è ]]]]]]]]]]]]]]]]]]]]]]]]]]]]" + stage);

    }
}
