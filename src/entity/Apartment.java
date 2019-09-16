package entity;

import java.util.Dictionary;
import java.util.List;

public class Apartment {

    private int idApt;
    private String name;                //apartment name 
    private String address;
    private String idOwner;
    private List<String> pictures;
    private String description;
    private float evaluation;
    private float taxes;
    private int capacity;
    private float area;
    //private Dictionary<String,String> services;

    public Apartment(int myIdApt, String myName, String myAddress, String myIdOwner, String myDescription, float myEvaluation, float myTaxes, int myCapacity, float myArea){

        this.idApt=myIdApt;
        this.name=myName;
        this.address=myAddress;
        this.idOwner=myIdOwner;
        this.description=myDescription;
        this.evaluation=myEvaluation;
        this.taxes=myTaxes;
        this.capacity=myCapacity;
        this.area=myArea;


    }


    //set
    public void setIdApt(int myIdApt){this.idApt=myIdApt;}

    public void setName(String myName){this.name=myName;}

    public void setAddress(String myAddress){this.address=myAddress;}

    public void setIdOwner(String myIdOwner){ this.idOwner=myIdOwner;}

    public void setPictures(List<String> myPictures){this.pictures=myPictures;}

    public void setDescription(String myDescription){this.description=myDescription;}

    public void setEvaluation(float evaluation) { this.evaluation = evaluation; }

    public void setTaxes(float myTaxes){this.taxes=myTaxes;}

    public void setCapacity(int myCapacity){this.capacity=myCapacity;}

    public void setArea(float myArea){this.area=myArea;}

    //get
    public int getIdApt(){return this.idApt;}

    public String getName(){return this.name;}

    public String getAddress() {
        return this.address;
    }

    public float getArea() {
        return this.area;
    }

    public float getEvaluation() {
        return this.evaluation;
    }

    public float getTaxes() {
        return this.taxes;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<String> getPictures() {
        return this.pictures;
    }

    public String getDescription() {
        return this.description;
    }

    public String getIdOwner() {
        return this.idOwner;
    }
}
