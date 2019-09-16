package entity;

public class User {

    private String id;
    private String password;
    private String userType;
    //public String nickname;


    public User(String id, String password, String userType) {

        this.id = id;
        this.password = password;
        this.userType = userType;    //1: locatore, 2:locatario
        //this.nickname= nickname;


    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUserType() {
        return userType;
    }

    /*
    public String getNickname() {
        return nickname;
    }
    */
}

