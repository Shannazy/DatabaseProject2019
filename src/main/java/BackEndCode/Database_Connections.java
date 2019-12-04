package BackEndCode;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.*;

public class Database_Connections {
    private String url;
    private String userName;
    private String password;


    private Connection mainConnector;

    public Database_Connections() {
        url = "jdbc:mysql://database-manage-project.c1ozpoa2prpl.us-east-2.rds.amazonaws.com:3306/FlightManagment?useSSL=false";
        userName = "DatabaseMan2019";
        password = "DatabaseProject2019";
    }

    public Connection getMainConnector() {
        return mainConnector;
    }

    public boolean getConnected(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            mainConnector = DriverManager.getConnection(url, userName, password);
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean closeConnection(){
       try{
           mainConnector.close();
           return true;
       } catch (Exception e){
           return false;
       }
    }
}
