package control;

import Facade.TenantAnnounceFacade;
import bean.TenantAnnounceBean;
import boundary.PostedTenantAnnounceController;
import dao.DBFunctions;
import entity.TenantAnnounce;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerTenantAnnounce {

    private static ControllerTenantAnnounce instance;

    private ControllerTenantAnnounce(){}

    public  static ControllerTenantAnnounce getInstance(){
        if(instance==null){
            instance = new ControllerTenantAnnounce();
        }
        return instance;
    }

//

    public void createTenantAnnounce(TenantAnnounceBean bean) {

        DBFunctions dbf = new DBFunctions();


        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/PostedTenantAnnounce.fxml"));
            Parent root = loader.load();
            PostedTenantAnnounceController controller = loader.getController();
            controller.showTenantAnnounce(bean);
            Scene scene = new Scene(root);

            Stage primaryStage = new Stage();

            primaryStage.setTitle("TenantAnnounce");
            primaryStage.setScene(scene);

            primaryStage.show();





        } catch (IOException e) {
            e.printStackTrace();
        }

            /***********************************************************
            // Volendo usare il pattern Facade, abbiamo sostituito il seguente codice con un metodo della classe TenantAnnounceFacade.

             =================== Codice iniziale:======================

             boolean permission;
             RulesInterface myRulesInterface= new Rules();
             Main notify=new Main();

             TenantAnnounce myTenantAnnounce = new TenantAnnounce(
                    bean.getTitle(), bean.getIdUser(), bean.getCity(),
                    bean.getRoom(), bean.getPeople(),bean.getBath(),
                    bean.getDateArr(),bean.getDateDep(), bean.getWifi(),
                    bean.getGarden(),bean.getAnimals(),bean.getAirConditionig(),bean.getParking());

             permission=myRulesInterface.booleanCheckAnnounce(myTenantAnnounce);

             if (permission){
             dbFunctions.insertNewTenantAnnounce(myTenantAnnounce);
             notify.notification(1,"CONFERMA","Il sottosistema rules ha accettato il tuo annuncio");
             }
             else{
             notify.notification(0,"ERRORE","Il sottosistema rules non ha accettato il tuo annuncio");
             }



             ================== Codice dopo aver creato la Facade:  ===================

             (il codice seguente non commentato)

             **********************************************************/

        TenantAnnounceFacade taf= new TenantAnnounceFacade(bean,dbf);
        taf.insertTenantAnnounce();

    }



}
