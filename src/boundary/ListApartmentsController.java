package boundary;

import bean.ApartmentBean;
import bean.UserBean;
import control.ControllerRenterAnnounce;
import entity.Apartment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ListApartmentsController {

    @FXML
    public ListView listView;

    @FXML
    public Button okBtn;

    private ApartmentBean aptBean= new ApartmentBean();
    private UserBean myUserBean= new UserBean();
    ArrayList<ApartmentBean> apartmentsList;
    Stage stageList;

    public ListApartmentsController() {}



    public void clickedOkBtn(ActionEvent actionEvent) {//prepara dati dell'annuncio selezionato nella listView

        Stage stage = (Stage)okBtn.getScene().getWindow();





            int aptIndex = listView.getSelectionModel().getSelectedIndex();  //prendo indice dell'apt selezionato su listView

            aptBean = apartmentsList.get(aptIndex);
            System.out.println("Tornati nel BOUNDARY: id dell'apt selezionato è= " + aptBean.getIdApt());

            System.out.println("element=" + aptIndex);
            ControllerRenterAnnounce cra = ControllerRenterAnnounce.getInstance();

            Apartment myApartment = cra.createApartment(aptBean);

            System.out.println("idApt= " + myApartment.getIdApt() + "   descrizione= " + myApartment.getDescription());

            //apro stage con le info gia prese dalle apt e le info che dovrò inserire manualmente

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/boundary/RenterAnnounceUI.fxml"));
                Parent root = loader.load();
                RenterAnnounceUIController controller = loader.getController();
                controller.createStage(myApartment, myUserBean);
                Scene scene = new Scene(root);

                stage.setTitle("Renter Announce");
                stage.setScene(scene);

                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    public int createListView(UserBean userBean) {      //creazione lista, ritorna 0 se lista vuota
        //funzione che crea query in controller, quindi chiamo controller e gli passo myUserBean.getId
        //funzione deve restituire la lista
        //costruisco lista

        //ArrayList<ApartmentBean> apartmentsList;
        ArrayList<String> apartmentsNameList= new ArrayList<>();    //per poi renderli Observable

        ControllerRenterAnnounce cra= ControllerRenterAnnounce.getInstance();
        apartmentsList=cra.createApartmentsList(userBean);    //lista di ApartamentBean


        for(int i=0;i<apartmentsList.size();i++){
            System.out.println("B: "+apartmentsList.get(i).getIdApt());

        }

        //converto apartmentsList in ObservableList per popolare la ListView

        for(int i=0;i<apartmentsList.size();i++){
            apartmentsNameList.add(apartmentsList.get(i).getName());
            System.out.println("B: "+apartmentsList.get(i).getIdApt());

        }

        ObservableList<String> listViewElements = FXCollections.observableList(apartmentsNameList);
        System.out.println("listViewElements= "+listViewElements);
        listView.setItems(listViewElements);

        myUserBean= userBean;

        if (apartmentsList.isEmpty()) {
            return 0;
        }
        return 1;
        }

    }

