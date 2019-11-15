package BackEndCode;

import BackEndCode.Database_Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
//            while (res.next()) {    //traverse each row
//                System.out.println(res.getString(1));   //print the name
//                System.out.println(res.getString(2));   //print the netid
//            }
            if (res.next()) {    //Simple verification that the person exist on our system. Doesn't actually compare names yet
                String user = res.getString(1);
                String pass = res.getString(2);
                if (user.equals(userName)) {  //compare the username found
                    if (pass.equals(Netid)) { //Compare the password found
                        res.close();    //close connections
                        connector.closeConnection();    //close the actual connection to stop from breaking the database
                        return true;
                    } else {
                        res.close();
                        connector.closeConnection();
                        return false;
                    }
                } else {
                    res.close();
                    connector.closeConnection();
                    return false;
                }

            } else {
                res.close();
                connector.closeConnection();
                return false;

            }
        } catch (Exception e) {
            connector.closeConnection();
            return false;
        }
    }

    public boolean searchCLients(String userName, String password){
        try {
            String search = "Select Email, Password From Clients WHERE Email = ? and Password = ?";   //Create string for searching admins
            PreparedStatement stmt = mainConnection.prepareStatement(search);   //create the actual statement
            stmt.setString(1, userName);    //Adding the first parameter
            stmt.setString(2, password); //Adding the second parameter
            ResultSet res = stmt.executeQuery();    //Cursor for my query result
//            while (res.next()) {    //traverse each row
//                System.out.println(res.getString(1));   //print the name
//                System.out.println(res.getString(2));   //print the netid
//            }
            if (res.next()) {    //Simple verification that the person exist on our system. Doesn't actually compare names yet
                String user = res.getString(1);
                System.out.println(user);
                String pass = res.getString(2);
                System.out.println(pass);
                if (user.equals(userName)) {  //compare the username found
                    if (pass.equals(password)) { //Compare the password found
                        res.close();    //close connections
                        connector.closeConnection();    //close the actual connection to stop from breaking the database
                        return true;
                    } else {
                        res.close();
                        connector.closeConnection();
                        return false;
                    }
                } else {
                    res.close();
                    connector.closeConnection();
                    return false;
                }

            } else {
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
