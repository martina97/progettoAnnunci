package dao;

public class DBQuery {
    public static final String insertTenantAnnounce = "INSERT INTO TenantAnnounce VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public static final String searchUserType = "SELECT userType FROM User where id= ?  AND password= ?";
    public static final String searchUser = "SELECT id, password FROM user where id= ? AND password= ?";
    public static final String searchApartments = "SELECT idApt, name, address, idOwner, pictures, description, evaluation, taxes, capacity, area FROM apartment where idOwner= ?";
    public static final String insertRenterAnnounce = "INSERT INTO RenterAnnounce VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
    public static final String searchNicknameByUser = "SELECT nickname FROM user WHERE id=?";
    public static final String getRenterAnnounces = "SELECT * FROM renterannounce";
    public static final String getTenantAnnounces = "SELECT * FROM tenantannounce";


}