package dao;

import bean.ApartmentBean;
import bean.RenterAnnounceBean;
import bean.TenantAnnounceBean;
import entity.RenterAnnounce;
import entity.TenantAnnounce;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static dao.DBQuery.*;

public class DBFunctions {

    private DBconnection dbConn = new DBconnection();

    public DBFunctions() {}

    //controllare che utente che effettua il login esiste nel db

    public int checkLogin(String id, String password) {
        String idLoaded;
        String pwdLoaded;

        System.out.println("DB- id: "+id);
        System.out.println("DB- password: "+password);

        try {

            PreparedStatement statement = dbConn.openConnection().prepareStatement(searchUser);
            statement.setString(1,id);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();


            if (rs.first() == false) {
                //risultato vuoto
                return 0;
            }


            idLoaded = rs.getString("id");
            pwdLoaded = rs.getString("password");

            System.out.println("DB- idLoaded: "+idLoaded);
            System.out.println("DB- passwordLoaded: "+pwdLoaded);

            if (idLoaded.equals(id) && pwdLoaded.equals(password)) {
                return 1;
            } else {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println("Database exception");
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return -1;      //qui non deve arrivarci
    }

    public String getUserType(String id, String password){
        String res;

        try {
            PreparedStatement statement = dbConn.openConnection().prepareStatement(searchUserType);
            statement.setString(1,id);
            statement.setString(2,password);
            ResultSet rs = statement.executeQuery();

            if (rs.first() == false) {
                //ERRORE- da gestire
                return null;
            }

            res = rs.getString("userType");
            return res;


        } catch (SQLException e) {
            System.out.println("Database exception");
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return null;      //qui non deve arrivarci

    }

    public boolean insertNewTenantAnnounce(TenantAnnounce announce) {

        try {


            PreparedStatement ps = dbConn.openConnection().prepareStatement(insertTenantAnnounce);
            ps.setString(1,null);
            ps.setString(2,announce.getTitle());
            ps.setString(3, announce.getName());
            ps.setString(4, announce.getCity());
            ps.setInt(5,announce.getRoom());
            ps.setInt(6,announce.getPeople());
            ps.setInt(7,announce.getBath());
            ps.setDate(8, Date.valueOf(announce.getDateArr()));
            ps.setDate(9,Date.valueOf(announce.getDateDep()));
            ps.setString(10, announce.getWifi());
            ps.setString(11,announce.getGarden());
            ps.setString(12,announce.getAnimals());
            ps.setString(13,announce.getAirConditioning());
            ps.setString(14,announce.getParking());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB exception");
            e.printStackTrace();
            return false;
        } finally {
            dbConn.closeConnection();
        }
        return true;
    }

    public boolean insertNewRenterAnnounce(RenterAnnounce announce){
        try {


            PreparedStatement ps = dbConn.openConnection().prepareStatement(insertRenterAnnounce);
            ps.setString(1, null);
            ps.setInt(2, announce.getIdApt());
            ps.setString(3, announce.getAddress());
            ps.setString(4, null);
            ps.setString(5,announce.getDescription());
            ps.setInt(6,announce.getCapacity());
            ps.setFloat(7,announce.getArea());
            ps.setFloat(8, announce.getPrice());
            ps.setDate(9 ,Date.valueOf(announce.getFrom()));
            ps.setDate(10, Date.valueOf(announce.getTo()));
            ps.setString(11,announce.getTitle());
            ps.setString(12,announce.getWifi());
            ps.setString(13,announce.getAnimals());
            ps.setString(14,announce.getParking());
            ps.setString(15,announce.getAirConditioning());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("DB exception");
            e.printStackTrace();
            return false;
        } finally {
            dbConn.closeConnection();
        }
        return true;



    }

    public ArrayList<ApartmentBean> searchUserApartments(String idOwner){

        try {
            ArrayList<ApartmentBean> nameApartments = new ArrayList<>();

            PreparedStatement statement = dbConn.openConnection().prepareStatement(searchApartments);
            statement.setString(1,idOwner);
            ResultSet rs = statement.executeQuery();   //restituisce tabella con tutti gli appartameni relativi a userID

            System.out.println("DB- subito dopo query");



            while (rs.next()) { //n righe
                ApartmentBean myApartmentBean = new ApartmentBean();
                myApartmentBean.setIdApt(Integer.parseInt(rs.getString("idApt")));

                myApartmentBean.setName(rs.getString("name"));
                myApartmentBean.setAddress(rs.getString("address"));
                myApartmentBean.setIdOwner(rs.getString("idOwner"));
                //myApartmentBean.setPictures(rs.getString("pictures"));
                myApartmentBean.setDescription(rs.getString("description"));
                myApartmentBean.setEvaluation(Float.parseFloat(rs.getString("evaluation")));
                myApartmentBean.setTaxes(Float.parseFloat(rs.getString("taxes")));
                myApartmentBean.setCapacity(Integer.parseInt(rs.getString("capacity")));
                myApartmentBean.setArea(Float.parseFloat(rs.getString("area")));

                nameApartments.add(myApartmentBean);
                System.out.println("sto nel while del db - idApt= "+myApartmentBean.getIdApt());

            }

            System.out.println("DB- subito dopo rs.next");

            System.out.println("Gli id ed i nomi degli appartamenti sono stati caricati ");

            return nameApartments;


        } catch (SQLException e) {
            System.out.println("Database exception");
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

        return null;      //qui non deve arrivarci


    }



    //bisogna fare due funzioni diverse per le liste perchè ci ritornano due tipi di dato diversi

    /*public ArrayList<RenterAnnounceBean> searchRenterAnnounces() {

        ArrayList<RenterAnnounceBean>  rList = new ArrayList<>();





    }

    public ArrayList<TenantAnnounceBean> searchTenantAnnounces() {
    }*/

    public void searchAnnounces(ArrayList<RenterAnnounceBean> renterList, ArrayList<TenantAnnounceBean> tenantList) {

        try{
            //faccio query che ritorna tutta la lista di annunci renter e la mette in rList
            PreparedStatement statement = dbConn.openConnection().prepareStatement(getRenterAnnounces);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                RenterAnnounceBean rab = new RenterAnnounceBean();



                rab.setIdAnn(Integer.parseInt(rs.getString("idAnn")));
                rab.setAddress(rs.getString("address"));
                rab.setDescription(rs.getString("description"));
                rab.setCapacity(Integer.parseInt(rs.getString("capacity")));
                rab.setArea(Float.parseFloat(rs.getString("area")));
                rab.setPrice(Float.parseFloat(rs.getString("price")));
                rab.setFromDate(LocalDate.parse(rs.getString("from")));
                rab.setToDate(LocalDate.parse(rs.getString("to")));
                rab.setTitle(rs.getString("title"));
                rab.setWifi(rs.getString("wifi"));
                rab.setAnimals(rs.getString("animals"));
                rab.setParking(rs.getString("parking"));
                rab.setAirConditioning(rs.getString("airConditioning"));
                System.out.println("DB: capacity= "+rab.getCapacity());

                renterList.add(rab);
            }

            PreparedStatement statement2 = dbConn.openConnection().prepareStatement(getTenantAnnounces);
            ResultSet rs2 = statement2.executeQuery();

            while(rs2.next()) {
                TenantAnnounceBean tab = new TenantAnnounceBean();

                tab.setTitle(rs2.getString("title"));
                tab.setName(rs2.getString("name"));
                tab.setCity(rs2.getString("city"));
                tab.setRoom(Integer.parseInt(rs2.getString("room")));
                tab.setPeople(Integer.parseInt(rs2.getString("capacity")));
                tab.setBath(Integer.parseInt(rs2.getString("bathroom")));
                tab.setDateArr(LocalDate.parse(rs2.getString("arrival")));
                tab.setDateDep(LocalDate.parse(rs2.getString("departure")));
                tab.setWifi(rs2.getString("wifi"));
                tab.setGarden(rs2.getString("garden"));
                tab.setAnimals(rs2.getString("pets"));
                tab.setAirConditioning(rs2.getString("airConditioning"));
                tab.setParking(rs2.getString("parking"));

                tenantList.add(tab);

            }


        } catch (SQLException e) {
            System.out.println("Database exception");
            e.printStackTrace();
        } finally {
            dbConn.closeConnection();
        }

     }

}














