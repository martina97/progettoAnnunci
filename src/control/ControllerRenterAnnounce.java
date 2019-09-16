package control;

import bean.ApartmentBean;
import bean.RenterAnnounceBean;
import bean.UserBean;
import boundary.PostedRenterAnnounceController;
import entity.Apartment;
import entity.RenterAnnounce;
import dao.DBFunctions;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class ControllerRenterAnnounce {

    ArrayList<String> idApartments = new ArrayList<String>();   //?????

    private static ControllerRenterAnnounce instance;

    private ControllerRenterAnnounce() {
    }

    public static ControllerRenterAnnounce getInstance() {
        if (instance == null) {
            instance = new ControllerRenterAnnounce();
        }
        return instance;
    }

    public void validateAnnounce(RenterAnnounceBean bean, Apartment apartment, Stage stage){
        String idOwner;

        RenterAnnounce announce;

        DBFunctions dbf= new DBFunctions();

        //idOwner=dbf.searchNickname(apartment.getIdOwner());  //prendo nickname proprietario, lo metto nell'annuncio ma lo vedo sulla label solo una volta che l'annuncio è stato pubblicato
        //bean.setIdOwner(idOwner);
        bean.setIdApt(apartment.getIdApt());
        bean.setAddress(apartment.getAddress());
        bean.setDescription(apartment.getDescription());
        bean.setCapacity(apartment.getCapacity());
        bean.setArea(apartment.getArea());

        System.out.println("id è " + bean.getIdApt());
        System.out.println("address "+ bean.getAddress());
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
        //System.out.println("idOwner" + bean.getIdOwner());



        //announce=new RenterAnnounce(apartment.getIdApt(),apartment.getAddress(),apartment.getDescription(),apartment.getCapacity(),apartment.getArea(),bean.getPrice(),bean.getFromDate(),bean.getToDate(),bean.getTitle(),bean.getWifi(),bean.getAnimals(),bean.getParking(),bean.getAirConditioning(),bean.getIdOwner());
       // announce=new RenterAnnounce(bean.getIdApt(),bean.getAddress(),bean.getDescription(),bean.getCapacity(),bean.getArea(),bean.getPrice(),bean.getFromDate(),bean.getToDate(),bean.getTitle(),bean.getWifi(),bean.getAnimals(),bean.getParking(),bean.getAirConditioning());

        /*
        System.out.println(announce.getIdApt());
        System.out.println(announce.getAddress());
        System.out.println(announce.getDescription());
        System.out.println(announce.getCapacity());
        System.out.println(announce.getArea());
        System.out.println(announce.getPrice());
        System.out.println(announce.getFrom());
        System.out.println(announce.getTo());
        System.out.println(announce.getTitle());
        System.out.println(announce.getWifi());
        System.out.println(announce.getAnimals());
        System.out.println(announce.getParking());
        System.out.println(announce.getAirConditioning());

        */


        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/PostedRenterAnnounce.fxml"));
            Parent root = loader.load();
            PostedRenterAnnounceController controller = loader.getController();
            controller.showRenterAnnounce(bean);
            Scene scene = new Scene(root);

            //Stage primaryStage = new Stage();
            stage.setTitle("Annuncio Affittasi");
            stage.setScene(scene);

            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

        announce=new RenterAnnounce(bean.getIdApt(),bean.getAddress(),bean.getDescription(),bean.getCapacity(),bean.getArea(),bean.getPrice(),bean.getFromDate(),bean.getToDate(),bean.getTitle(),bean.getWifi(),bean.getAnimals(),bean.getParking(),bean.getAirConditioning());

        dbf.insertNewRenterAnnounce(announce);

    }

    public ArrayList<ApartmentBean> createApartmentsList(UserBean bean){
        //List <String> apartmentsList=null;
        ArrayList<ApartmentBean> apartmentsList;

        System.out.println("sto nel Control");

        DBFunctions dbf= new DBFunctions();
        apartmentsList=dbf.searchUserApartments(bean.getId());

        //System.out.println("idApartments.size()="+idApartments.size());
        System.out.println("apartmentsList.size()="+apartmentsList.size());

        for(int i=0;i<apartmentsList.size();i++){
            System.out.println("C: "+apartmentsList.get(i).getIdApt());
            System.out.println("C: "+apartmentsList.get(i).getName());
        }
        return apartmentsList;
    }


    public Apartment createApartment(ApartmentBean aptBean) {
        Apartment myApartment= new Apartment(aptBean.getIdApt(),aptBean.getName(),aptBean.getAddress(),aptBean.getIdOwner(),aptBean.getDescription(),aptBean.getEvaluation(),aptBean.getTaxes(),aptBean.getCapacity(),aptBean.getArea());
        System.out.println("indirizzo: "+myApartment.getAddress());
        return myApartment;
    }
}