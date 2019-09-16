package bean;

public class UserBean {
    private String id;
    private String password;
    private String userType;

    public UserBean(){}

    public void setId(String myId){this.id=myId;}

    public void setPassword(String myPassword){this.password=myPassword;}

    public void setUserType(String myUserType){this.userType=myUserType;}

    public String getId(){return this.id;}

    public String getPassword(){return this.password;}

    public String getUserType(){return this.userType;}


}
