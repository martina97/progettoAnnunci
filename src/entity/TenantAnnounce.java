package entity;


import java.time.LocalDate;

public class TenantAnnounce {

    private String title;
    private String name;
    private String city;
    private int room;
    private int people;
    private int bath;
    private LocalDate dateArr;
    private LocalDate dateDep;
    private String wifi;
    private String garden;
    private String animals;
    private String airConditioning;
    private String parking;

    public TenantAnnounce(String title, String name, String city, int room, int people, int bath, LocalDate dateArr, LocalDate dateDep, String wifi, String garden,
                          String animals, String airConditionig, String parking) {
        this.title = title;
        this.name = name;
        this.city = city;
        this.room = room;
        this.people = people;
        this.bath = bath;
        this.dateArr = dateArr;
        this.dateDep = dateDep;
        this.wifi = wifi;
        this.garden = garden;
        this.animals = animals;
        this.airConditioning = airConditionig;
        this.parking = parking;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public int getRoom() {
        return room;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public int getPeople() {
        return this.people;
    }

    public void setBath(int bath) {
        this.bath = bath;
    }

    public int getBath() {
        return this.bath;
    }

    public void setDateArr(LocalDate dateArr) {
        this.dateArr = dateArr;
    }

    public LocalDate getDateArr() {
        return this.dateArr;
    }

    public void setDateDep(LocalDate dateDep) {
        this.dateDep = dateDep;
    }

    public LocalDate getDateDep() {
        return this.dateDep;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi;
    }

    public String getWifi() {
        return wifi;
    }

    public void setGarden(String garden) {
        this.garden = garden;
    }

    public String getGarden() {
        return garden;
    }

    public void setAnimals(String animals) {
        this.animals = animals;
    }

    public String getAnimals() {
        return animals;
    }

    public void setAirConditioning(String airConditioning) {
        this.airConditioning = airConditioning;
    }

    public String getAirConditioning() {
        return airConditioning;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }

    public String getParking() {
        return parking;
    }

}
