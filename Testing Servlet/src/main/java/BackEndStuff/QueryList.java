package BackEndStuff;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryList {
    Connection mainConnection;
    DatabaseConnection connector;

    public QueryList(DatabaseConnection connector) {
        this.connector = connector;
    }

    public boolean searchAdmins(String userName, String Netid) {

        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();

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
                        stmt.close();
                        connector.closeConnection();    //close the actual connection to stop from breaking the database
                        return true;
                    } else {
                        res.close();
                        stmt.close();
                        connector.closeConnection();
                        return false;
                    }
                } else {
                    res.close();
                    stmt.close();
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

    public boolean searchclients(String userName, String password) {
        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();

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
                        stmt.close();
                        connector.closeConnection();    //close the actual connection to stop from breaking the database
                        return true;
                    } else {
                        res.close();
                        stmt.close();
                        connector.closeConnection();
                        return false;
                    }
                } else {
                    res.close();
                    stmt.close();
                    connector.closeConnection();
                    return false;
                }

            } else {
                res.close();
                stmt.close();
                connector.closeConnection();
                return false;

            }
        } catch (Exception e) {
            connector.closeConnection();
            return false;
        }

    }

    public boolean registerClient(String email, String Name, String phone,
                                  String CreationDate, String pass, String DOB) {
        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String insert = "INSERT INTO Clients value(?,?,?,?,?,?)";
            PreparedStatement register = mainConnection.prepareStatement(insert);
            register.setString(1, email);
            register.setString(2, Name);
            register.setString(3, phone);
            register.setString(4, CreationDate);
            register.setString(5, pass);
            register.setString(6, DOB);
            register.executeUpdate();
            register.close();
            connector.closeConnection();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

//    public List<List<String>> initialOneWayTicket(String departureDate, String departureLocation, String destinationLocation ){
//        List<List<String>> allTickets = new ArrayList();
//        try{
//            connector.getConnected();
//            mainConnection = connector.getMainConnector();
//            String tickets = "Select * FROM Flight WHERE " +
//                    "`Departure Date` = ? AND" +
//                    " `Departure_Location` = ? AND" +
//                    " `Destination Location` = ?";
//            PreparedStatement searchFlights = mainConnection.prepareStatement(tickets);
//            searchFlights.setString(1, departureDate);
//            searchFlights.setString(2, departureLocation);
//            searchFlights.setString(3, destinationLocation);
//            ResultSet res = searchFlights.executeQuery();
//            while (res.next()){
//                List<String> thisColumn = new ArrayList<String>();
//                String flightNum = res.getString("Flight#");
//                String departDate = String.valueOf(res.getDate("Departure Date"));
//                String departTime = String.valueOf(res.getTime("Departure Time"));
//                String departLoc = res.getString("Departure_Location");
//                String destDate = String.valueOf(res.getDate("Destination Date");
//                String destTime = String.valueOf(res.getTime("Destination Time"));
//                String destLoc = res.getString("Destination Location");
//                String flightClass = res.getString("Class");
//                String Airline  = res.getString("Airline");
//                String PlaneID = res.getString("FlightID");
//                String Price = res.getString("Price");
//                allTickets.add(thisColumn);
//            }
//
//        } catch (Exception e) {
//            connector.closeConnection();
//            return
//        }
//    }
}
