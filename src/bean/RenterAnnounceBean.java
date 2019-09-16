package bean;



import javafx.scene.image.Image;

import java.time.LocalDate;
import java.util.List;

public class RenterAnnounceBean {

    private int idAnn;
    private int idApt;    //id appartamento a cui si riferisce
    private String address;
    private String idOwner;
    private List<Image> pictures;
    private String description;
    private float evaluation;
    private int capacity;
    private float area;
    private float price;
    private LocalDate from;
    private LocalDate to;
    private String title;
    private String wifi;
    private  String animals;
    private String parking;
    private String airConditioning;
    //private String nickname;

    public RenterAnnounceBean(){};

    //set

    public void setIdAnn(int myIdAnn){this.idAnn=myIdAnn;}

    public void setAddress(String myAddress){this.address=myAddress;}

    public void setDescription(String myDescription){this.description=myDescription;}

    public void setCapacity(int myCapacity){this.capacity=myCapacity;}

    public void setArea(float myArea){this.area=myArea;}

    public void setIdApt(int myIdApt){this.idApt=myIdApt;}

    public void setTitle(String myTitle){this.title=myTitle;}

    public void setPrice(float myPrice){this.price=myPrice;}

    public void setFromDate(LocalDate from){ this.from=from;}

    public void setToDate(LocalDate to){this.to=to;}

    public void setWifi(String value){this.wifi=value;}

    public void setAnimals(String value){ this.animals=value;}

    public void setParking(String value){this.parking=value;}

    public void setAirConditioning(String value){this.airConditioning=value;}

    //public void setNickname(String myNickname){this.nickname=myNickname;}

    public void setIdOwner(String myId){this.idOwner=myId;}

    public void setPictures(List<Image> pictures) { this.pictures = pictures; }

    //get
    public int getIdApt(){return this.idApt;}

    public int getIdAnn(){return this.idAnn;}

    public String getTitle(){return this.title;}

    public float getPrice(){return this.price;};

    public LocalDate getFromDate(){return this.from;}

    public LocalDate getToDate(){return this.to;}

    public String getWifi(){return this.wifi;}

    public String getAnimals(){return this.animals;}

    public String getParking(){return this.parking;}

    public String getAirConditioning(){return this.airConditioning;}

    //public String getNickname(){return this.nickname;}

    public String getIdOwner(){return this.idOwner;}

    public String getAddress() {return this.address;}

    public String getDescription() { return this.description; }


    public int getCapacity() {return this.capacity;}

    public float getArea() {return this.area;}

    public List<Image> getPictures() { return this.pictures; }
}