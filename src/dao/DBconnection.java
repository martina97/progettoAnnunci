package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {

    private final String USER = "root";
    private final String PASS = "root";
    private final String DB_URL = "jdbc:mariadb://127.0.0.1:3406/provadb";

    //private final String DB_URL = "jdbc:mariadb://192.168.2.106:3406/provadb";
    //private final String DB_URL = "jdbc:mariadb://127.0.0.1:3306/provadb";
    private final String DRIVER_CLASS_NAME = "org.mariadb.jdbc.Driver";

    private Connection connection = null;
    

    // Operazione per aprire la connessione con il DB
    public Connection openConnection() {
        if (connection != null) return connection;
        try {
            Class.forName(DRIVER_CLASS_NAME);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Connection exception");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Exception");
            e.printStackTrace();
        }
        return connection;
    }

    // Operazione per chiudere la connessione con il DB
    public void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection exception");
            e.printStackTrace();
        }
    }
}