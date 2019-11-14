import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryList {
    Connection mainConnection;
    Database_Connections connector;

    public QueryList(Database_Connections connector) {
        this.connector = connector;
        connector.getConnected();
        mainConnection = connector.getMainConnector();

    }

    public boolean searchAdmins(String userName, String Netid) {

        try {
            String search = "Select * From Admins WHERE Full_Name = ? and Netid = ?";   //Create string for searching admins
            PreparedStatement stmt = mainConnection.prepareStatement(search);   //create the actual statement
            stmt.setString(1, userName);    //Adding the first parameter
            stmt.setString(2, Netid); //Adding the second parameter
            ResultSet res = stmt.executeQuery();    //Cursor for my query result

            if (res.next()){    //Simple verification that the person exist on our system. Doesn't actually compare names yet
                res.close();
                connector.closeConnection();
                return true;
            }
            else {
                res.close();
                connector.closeConnection();
                return false;

            }
        } catch (Exception e) {
            connector.closeConnection();
            return false;
        }
    }
}
