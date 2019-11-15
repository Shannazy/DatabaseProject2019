package BackEndCode;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private String url;
    private String userName;
    private String password;
    private Connection mainConnector;

    public DatabaseConnection() {
        url = "jdbc:mysql://database-manage-project.c1ozpoa2prpl.us-east-2.rds.amazonaws.com:3306/FlightManagment?useSSL=false";
        userName = "DatabaseMan2019";
        password = "DatabaseProject2019";
    }

    public Connection getMainConnector() {
        return mainConnector;
    }

    public Boolean getConnected(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            mainConnector = DriverManager.getConnection(url, userName, password);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean closeConnection(){
        try{
            mainConnector.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String getUserName() {
        return userName;
    }
}
