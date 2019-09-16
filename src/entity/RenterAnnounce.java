package entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class RenterAnnounce {

    private int idAnn;
    private int idApt;    //id appartamento a cui si riferisce
    private String address;
    private String idOwner;
    private List<String> pictures;
    private String description;
    private int capacity;
    private float area;
    private float price;
    private LocalDate from;
    private LocalDate to;
    private String title;
    private String wifi;
    private String animals;
    private String parking;
    private String airConditioning;
    //private String nickname;

    //public RenterAnnounce(int idApt, String address,  String description,int capacity, float area, float price, LocalDate from, LocalDate to, String title, String wifi, String animals, String parking, String airConditioning, String nickname) {

    public RenterAnnounce(int idApt, String address,  String description,int capacity, float area, float price, LocalDate from, LocalDate to, String title, String wifi, String animals, String parking, String airConditioning) {

        this.title = title;
        this.idApt = idApt;
        this.address= address;
        this.description = description;
        this.capacity = capacity;
        this.area = area;
        this.price = price;
        this.from = from;
        this.to = to;
        this.wifi = wifi;
        this.animals = animals;
        this.airConditioning = airConditioning;
        this.parking = parking;
        //this.nickname=nickname;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAddress(String address) {this.address = address; }

    public String getAddress() { return address; }

    public void setArea(float area) { this.area = area; }

    public float getArea() { return area; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getCapacity() { return capacity; }

    public void setDescription(String description) { this.description = description; }

    public String getDescription() { return description; }



    public void setFrom(LocalDate from) { this.from = from; }

    public LocalDate getFrom() { return from; }

    public void setIdAnn(int idAnn) { this.idAnn = idAnn; }

    public int getIdAnn() { return idAnn; }

    public void setIdApt(int idApt) { this.idApt = idApt; }

    public int getIdApt() { return idApt; }

    public void setAirConditioning(String airConditioning) { this.airConditioning = airConditioning; }

    public String getAirConditioning() { return airConditioning; }

    public void setIdOwner(String idOwner) { this.idOwner = idOwner; }

    public String getIdOwner() { return idOwner; }

    public void setPictures(List<String> pictures) { this.pictures = pictures; }

    public List<String> getPictures() { return pictures; }

    public void setPrice(float price) { this.price = price; }

    public float getPrice() { return price; }

    public void setTo(LocalDate to) { this.to = to; }

    public LocalDate getTo() { return to; }


    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getWifi() {
        return wifi;
    }



    public void setAnimals(String animals) {
        this.animals = animals;
    }

    public String getAnimals() {
        return animals;
    }



    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getParking() {
        return parking;
    }

    //public void setNickname(String myNickname){this.nickname=myNickname;}

    //public String getNickname(){return this.nickname;}




}
