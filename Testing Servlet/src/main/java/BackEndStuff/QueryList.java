package BackEndStuff;

import com.mysql.cj.protocol.Resultset;

import javax.naming.PartialResultException;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    public List<List<String>> initialOneWayTicket(String departureDate, String departureLocation, String destinationLocation) {
        List<List<String>> allTickets = new ArrayList<List<String>>();
        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String tickets = "Select * FROM Flight WHERE " +
                    "`Departure Date` = ? AND" +
                    " `Departure_Location` = ? AND" +
                    " `Destination Location` = ?";
            PreparedStatement searchFlights = mainConnection.prepareStatement(tickets);
            searchFlights.setString(1, departureDate);
            searchFlights.setString(2, departureLocation);
            searchFlights.setString(3, destinationLocation);
            ResultSet res = searchFlights.executeQuery();
            while (res.next()) {
                List<String> thisColumn = new ArrayList<String>();
                thisColumn.add(res.getString("Flight#"));
                thisColumn.add(res.getString("Departure Date"));
                thisColumn.add(res.getString("Departure Time"));
                thisColumn.add(res.getString("Departure_Location"));
                thisColumn.add(res.getString("Destination Date"));
                thisColumn.add(res.getString("Destination Time"));
                thisColumn.add(res.getString("Destination Location"));
                thisColumn.add(res.getString("Class"));
                thisColumn.add(res.getString("Airline"));
                thisColumn.add(res.getString("FlightID"));
                thisColumn.add(res.getString("Price"));
                allTickets.add(thisColumn);
            }
            res.close();
            searchFlights.close();
            connector.closeConnection();
            return allTickets;
        } catch (Exception e) {

            connector.closeConnection();
            List<String> failed = new ArrayList<String>();
            failed.add("Something went wrong");
            allTickets.add(failed);
            return allTickets;
        }
    }

    public UserInfo getUserInfo(String username) throws SQLException {
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String search = "Select * From Clients where `Email` = ?";   //Create string for searching admins
        PreparedStatement stmt = mainConnection.prepareStatement(search);   //create the actual statement
        stmt.setString(1, username);    //Adding the first parameter
        ResultSet res = stmt.executeQuery();

        if (res.next()) {
            UserInfo currentUser = new UserInfo(res.getString("Email"),
                    res.getString("Name"),
                    (res.getString("Phone")),
                    (res.getString("Creation_Date")),
                    (res.getString("DOB")));
            stmt.close();
            res.close();
            connector.closeConnection();
            return currentUser;
        } else {
            UserInfo failedUser = new UserInfo("fail", "fail", "Fail", "Fail", "Fail");
            stmt.close();
            res.close();
            connector.closeConnection();
            return failedUser;
        }
    }

    public List<List<String>> getAllReservations(String username) throws SQLException {
        List<List<String>> reservationResult = new ArrayList<List<String>>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String tickets = "SELECT * FROM Flight join Ticket " +
                "on Flight.`Flight#` = Ticket.`Flight#` " +
                "where `ClientEmail` = ? " ;
        PreparedStatement findReservation = mainConnection.prepareStatement(tickets);
        findReservation.setString(1, username);
        ResultSet res = findReservation.executeQuery();
        while (res.next()){
            List<String> columnValue = new ArrayList<String>();
            columnValue.add(res.getString("TicketNumber"));
            columnValue.add(res.getString("Departure Date"));
            columnValue.add(res.getString("Departure Time"));
            columnValue.add(res.getString("Departure_Location"));
            columnValue.add(res.getString("Destination Date"));
            columnValue.add(res.getString("Destination Time"));
            columnValue.add(res.getString("Destination Location"));
            columnValue.add(res.getString("Airline"));
            columnValue.add(res.getString("FlightID"));
            columnValue.add(res.getString("Class"));
            columnValue.add(res.getString("Total Price"));
            reservationResult.add(columnValue);
        }
        findReservation.close();
        res.close();
        connector.closeConnection();
        return reservationResult;

    }

    public List<List<String>> getComingReservations(String username) throws SQLException{
        List<List<String>> reservationResult = new ArrayList<List<String>>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String tickets = "SELECT * FROM Flight join Ticket " +
                "on Flight.`Flight#` = Ticket.`Flight#` " +
                "where `ClientEmail` = ? and `Departure Date` > ? " ;
        PreparedStatement findReservation = mainConnection.prepareStatement(tickets);
        findReservation.setString(1, username);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String stringDate = dateFormat.format(date);
        findReservation.setString(2,stringDate);
        ResultSet res = findReservation.executeQuery();
        while (res.next()){
            List<String> columnValue = new ArrayList<String>();
            columnValue.add(res.getString("TicketNumber"));
            columnValue.add(res.getString("Departure Date"));
            columnValue.add(res.getString("Departure Time"));
            columnValue.add(res.getString("Departure_Location"));
            columnValue.add(res.getString("Destination Date"));
            columnValue.add(res.getString("Destination Time"));
            columnValue.add(res.getString("Destination Location"));
            columnValue.add(res.getString("Airline"));
            columnValue.add(res.getString("FlightID"));
            columnValue.add(res.getString("Class"));
            columnValue.add(res.getString("Total Price"));
            reservationResult.add(columnValue);
        }
        findReservation.close();
        res.close();
        connector.closeConnection();
        return reservationResult;

    }

    public List<List<String>> getPastReservation(String username) throws SQLException{
        List<List<String>> reservationResult = new ArrayList<List<String>>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String tickets = "SELECT * FROM Flight join Ticket " +
                "on Flight.`Flight#` = Ticket.`Flight#` " +
                "where `ClientEmail` = ? and `Departure Date` <= ? " ;
        PreparedStatement findReservation = mainConnection.prepareStatement(tickets);
        findReservation.setString(1, username);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String stringDate = dateFormat.format(date);
        findReservation.setString(2,stringDate);
        ResultSet res = findReservation.executeQuery();
        while (res.next()){
            List<String> columnValue = new ArrayList<String>();
            columnValue.add(res.getString("TicketNumber"));
            columnValue.add(res.getString("Departure Date"));
            columnValue.add(res.getString("Departure Time"));
            columnValue.add(res.getString("Departure_Location"));
            columnValue.add(res.getString("Destination Date"));
            columnValue.add(res.getString("Destination Time"));
            columnValue.add(res.getString("Destination Location"));
            columnValue.add(res.getString("Airline"));
            columnValue.add(res.getString("FlightID"));
            columnValue.add(res.getString("Class"));
            columnValue.add(res.getString("Total Price"));
            reservationResult.add(columnValue);
        }
        findReservation.close();
        res.close();
        connector.closeConnection();
        return reservationResult;

    }
}

