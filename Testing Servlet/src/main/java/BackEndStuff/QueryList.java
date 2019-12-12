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
import java.util.Calendar;
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

    public List<String> getUserInfo(String username) throws SQLException {
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String search = "Select * From Clients where `Email` = ?";   //Create string for searching admins
        PreparedStatement stmt = mainConnection.prepareStatement(search);   //create the actual statement
        stmt.setString(1, username);    //Adding the first parameter
        ResultSet res = stmt.executeQuery();
        List<String> currentUser = new ArrayList<String>();

        if (res.next()) {
            currentUser.add(res.getString("Email"));
            currentUser.add(res.getString("Name"));
            currentUser.add(res.getString("Phone"));
            currentUser.add(res.getString("Creation_Date"));
            currentUser.add(res.getString("DOB"));
            stmt.close();
            res.close();
            connector.closeConnection();
            return currentUser;
        } else {
            stmt.close();
            res.close();
            connector.closeConnection();
            return currentUser;
        }
    }

    public List<List<String>> getAllReservations(String username) throws SQLException {
        List<List<String>> reservationResult = new ArrayList<List<String>>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String tickets = "SELECT * FROM Flight join Ticket " +
                "on Flight.`Flight#` = Ticket.`Flight#` " +
                "where `ClientEmail` = ? ";
        PreparedStatement findReservation = mainConnection.prepareStatement(tickets);
        findReservation.setString(1, username);
        ResultSet res = findReservation.executeQuery();
        while (res.next()) {
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

    public List<List<String>> getComingReservations(String username) throws SQLException {
        List<List<String>> reservationResult = new ArrayList<List<String>>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String tickets = "SELECT * FROM Flight join Ticket " +
                "on Flight.`Flight#` = Ticket.`Flight#` " +
                "where `ClientEmail` = ? and `Departure Date` > ? ";
        PreparedStatement findReservation = mainConnection.prepareStatement(tickets);
        findReservation.setString(1, username);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String stringDate = dateFormat.format(date);
        findReservation.setString(2, stringDate);
        ResultSet res = findReservation.executeQuery();
        while (res.next()) {
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

    public List<List<String>> getPastReservation(String username) throws SQLException {
        List<List<String>> reservationResult = new ArrayList<List<String>>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String tickets = "SELECT * FROM Flight join Ticket " +
                "on Flight.`Flight#` = Ticket.`Flight#` " +
                "where `ClientEmail` = ? and `Departure Date` <= ? ";
        PreparedStatement findReservation = mainConnection.prepareStatement(tickets);
        findReservation.setString(1, username);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String stringDate = dateFormat.format(date);
        findReservation.setString(2, stringDate);
        ResultSet res = findReservation.executeQuery();
        while (res.next()) {
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

    public List<List<String>> getResWithAirport(String username, String AirportCode) throws SQLException {
        List<List<String>> reservationResult = new ArrayList<List<String>>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String tickets = "SELECT * FROM Flight join Ticket " +
                "on Flight.`Flight#` = Ticket.`Flight#` " +
                "where `ClientEmail` = ? and `Departure_Location` = ? " +
                "OR `Destination Location` = ?";
        PreparedStatement findReservation = mainConnection.prepareStatement(tickets);
        findReservation.setString(1, username);
        findReservation.setString(2, AirportCode);
        findReservation.setString(3, AirportCode);
        ResultSet res = findReservation.executeQuery();
        while (res.next()) {
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

    public List<List<String>> getDeparturesFromAirport (String AirportCode) throws SQLException {
        List<List<String>> departureFlights = new ArrayList<List<String>>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String departing = "SELECT * FROM Departure where `Airport_AirportID` = ?";
        PreparedStatement findDepart = mainConnection.prepareStatement(departing);
        findDepart.setString(1, AirportCode);
        ResultSet res = findDepart.executeQuery();
        while(res.next()){
            List<String> departDetail = new ArrayList<String>();
            departDetail.add(res.getString("Date"));
            departDetail.add(res.getString("Time"));
            departDetail.add(res.getString("Airport_AirportID"));
            departDetail.add(res.getString("Airline_Code"));
            departDetail.add(res.getString("CraftID"));
            departureFlights.add(departDetail);
        }
        res.close();
        findDepart.close();
        connector.closeConnection();
        return departureFlights;
    }

    public List<List<String>> getArrivalToAirport (String AirportCode) throws SQLException {
        List<List<String>> arrivalFlights = new ArrayList<List<String>>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String arriving = "SELECT * FROM Arrival where `Airport_Airport ID` = ?";
        PreparedStatement findArrivals = mainConnection.prepareStatement(arriving);
        findArrivals.setString(1, AirportCode);
        ResultSet res = findArrivals.executeQuery();
        while(res.next()){
            List<String> arrivalDetails = new ArrayList<String>();
            arrivalDetails.add(res.getString("Date"));
            arrivalDetails.add(res.getString("Time"));
            arrivalDetails.add(res.getString("Airport_Airport ID"));
            arrivalDetails.add(res.getString("Depart Date"));
            arrivalDetails.add(res.getString("Depart Time"));
            arrivalDetails.add(res.getString("DepartLocation"));
            arrivalDetails.add(res.getString("AirlineCode"));
            arrivalDetails.add(res.getString("CraftID"));
            arrivalFlights.add(arrivalDetails);
        }
        res.close();
        findArrivals.close();
        connector.closeConnection();
        return arrivalFlights;
    }

    public boolean adminDelete (String table, String email) throws SQLException {

        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            if (table.equals("Clients")) {
                String deletingTable = "Delete FROM `"+table+"` where `Email` = ?";
                PreparedStatement deleter = mainConnection.prepareStatement(deletingTable);
                deleter.setString(1, email);
                deleter.executeUpdate();
                deleter.close();
                connector.closeConnection();
                return true;
            }
            else if (table.equals("CustomerRep")) {
                String deletingTable = "Delete FROM `"+table+"` where `CustomerRep_Username` = ?";
                PreparedStatement deleter = mainConnection.prepareStatement(deletingTable);
                deleter.setString(1, email);
                deleter.executeUpdate();
                deleter.close();
                connector.closeConnection();
                return true;
            }
        } catch (Exception e){
            connector.closeConnection();
            return false;
        }
        return false;
    }


    public List<List<String>> flexableNoFilter (String departureDate, String departureLocation, String destinationLocation){
        List<List<String>> flexableTiickets = new ArrayList<List<String>>();
        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String tickets = "Select * FROM Flight WHERE " +
                    "`Departure Date` Between ? AND ? AND" +
                    " `Departure_Location` = ? AND" +
                    " `Destination Location` = ?";
            PreparedStatement searchFlights = mainConnection.prepareStatement(tickets);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c =Calendar.getInstance();
            c.setTime(sdf.parse(departureDate));
            c.add(Calendar.DAY_OF_MONTH, -3);
            searchFlights.setString(1, sdf.format(c.getTime()));

            c.setTime(sdf.parse(departureDate));
            c.add(Calendar.DAY_OF_MONTH, 3);
            searchFlights.setString(2, sdf.format(c.getTime()));
            searchFlights.setString(3, departureLocation);
            searchFlights.setString(4, destinationLocation);
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
                flexableTiickets.add(thisColumn);
            }
            res.close();
            searchFlights.close();
            connector.closeConnection();
            return flexableTiickets;
        } catch (Exception e) {

            connector.closeConnection();
            List<String> failed = new ArrayList<String>();
            failed.add("Something went wrong");
            flexableTiickets.add(failed);
            return flexableTiickets;
        }
    }

    public List<List<String>> dynamicQuery  (String departureDate, String departureLocation, String destinationLocation, String priceLow,
                                                String priceHigh, String Airline, boolean Flex, String Sort){
        List<List<String>> flightsResult = new ArrayList<List<String>>();
        try {
            StringBuilder dynamicQuery =new StringBuilder("Select * From Flight where" +
                    " `Departure_Location` = ? and" +
                    " `Destination Location` = ?");
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            if(Flex){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c =Calendar.getInstance();
                c.setTime(sdf.parse(departureDate));
                c.add(Calendar.DAY_OF_MONTH, -3);
                String threeLess = sdf.format(c.getTime());
                c.setTime(sdf.parse(departureDate));
                c.add(Calendar.DAY_OF_MONTH, 3);
                String threeMore = sdf.format((c.getTime()));
                dynamicQuery.append(" and " +
                        "`Departure Date` between \'"+threeLess+"\' and \'"+
                        threeMore+"\'");
            }
            if(!Flex){
                dynamicQuery.append(" and `Departure Date` = \'"+departureDate+"\'");
            }
            if(Airline != null){
                dynamicQuery.append(" and `Airline` = \""+Airline+"\"");
            }
            if (priceLow!= null){
                dynamicQuery.append(" and `Price` >= "+priceLow);

            }
            if (priceHigh != null){
                dynamicQuery.append(" and `Price` <= "+ priceHigh);
            }
            if(Sort != null){
                dynamicQuery.append(" order by `"+Sort+"`;");
            }
            String finalQuery = dynamicQuery.toString();
            PreparedStatement searchFlights = mainConnection.prepareStatement(finalQuery);
            searchFlights.setString(1, departureLocation);
            searchFlights.setString(2, destinationLocation);
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
                flightsResult.add(thisColumn);
            }
            res.close();
            searchFlights.close();
            connector.closeConnection();
            return flightsResult;
        } catch (Exception e) {
        e.printStackTrace();
            connector.closeConnection();
            List<String> failed = new ArrayList<String>();
            failed.add("Something went wrong");
            flightsResult.add(failed);
            return flightsResult;
        }
    }
    public List<String> airportList() throws SQLException {
        List<String> airportList = new ArrayList<String>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String search = "Select * From Airport ";   //Create string for searching admins
        PreparedStatement stmt = mainConnection.prepareStatement(search);
        ResultSet res = stmt.executeQuery();
        while(res.next()){
            airportList.add(res.getString("AirportID"));
        }
        stmt.close();
        res.close();
        connector.closeConnection();
    return airportList;
    }

    public List<String> airlineList() throws SQLException {
        List<String> airlines = new ArrayList<String>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String search = "Select * From Airlines ";   //Create string for searching admins
        PreparedStatement stmt = mainConnection.prepareStatement(search);
        ResultSet res = stmt.executeQuery();
        while(res.next()){
            airlines.add(res.getString("Airline_Code"));
        }
        stmt.close();
        res.close();
        connector.closeConnection();
        return airlines;

    }

    // Get sales report
    public List<List<String>> getSalesReport(String queryType, String input) throws SQLException{
        List<List<String>> queryResult = new ArrayList<List<String>>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String query = "";
        if(queryType.equals("flight")){
            query = "select Flight.`Flight#`, count(Ticket.`Flight#`) as `Tickets Sold`, Ticket.`Total Price` * 0.25 as `Total Revenue`" +
                    " from Ticket join\n" +
                    "Flight on Ticket.`Flight#` = Flight.`Flight#` where Flight.`Flight#` = ?";
            PreparedStatement findCustomers = mainConnection.prepareStatement(query);
            findCustomers.setString(1, input);
            ResultSet res = findCustomers.executeQuery();
            while(res.next()){
                List<String> customerDetails = new ArrayList<String>();
                customerDetails.add(res.getString("Flight#"));
                customerDetails.add(res.getString("Tickets Sold"));
                customerDetails.add(res.getString("Total Revenue"));
                queryResult.add(customerDetails);
            }
            res.close();
            findCustomers.close();
            connector.closeConnection();
            return queryResult;
        }
        else if(queryType.equals("customer")){
            query = "SELECT Name, count(ClientEmail) as `Tickets Sold`, sum(`Total Price`*0.25) as `Total Revenue`" +
                    "FROM Ticket JOIN Clients on ClientEmail = Email where `ClientEmail` = ?";
            PreparedStatement findCustomers = mainConnection.prepareStatement(query);
            findCustomers.setString(1, input);
            ResultSet res = findCustomers.executeQuery();
            while(res.next()){
                List<String> customerDetails = new ArrayList<String>();
                customerDetails.add(res.getString("Name"));
                customerDetails.add(res.getString("Tickets Sold"));
                customerDetails.add(res.getString("Total Revenue"));
                queryResult.add(customerDetails);
            }
            res.close();
            findCustomers.close();
            connector.closeConnection();
            return queryResult;
        }
        else if(queryType.equals("airline")){
            query = "select Flight.Airline, count(`Airline`)as `Tickets Sold`,sum(`Total Price`) * 0.25 as `Total Revenue` from Ticket join " +
                    "Flight on Ticket.`Flight#` = Flight.`Flight#` where Flight.Airline = ? group by Flight.Airline";
            PreparedStatement findCustomers = mainConnection.prepareStatement(query);
            findCustomers.setString(1, input);
            ResultSet res = findCustomers.executeQuery();
            while(res.next()){
                List<String> customerDetails = new ArrayList<String>();
                customerDetails.add(res.getString("Airline"));
                customerDetails.add(res.getString("Tickets Sold"));
                customerDetails.add(res.getString("Total Revenue"));
                queryResult.add(customerDetails);
            }
            res.close();
            findCustomers.close();
            connector.closeConnection();
            return queryResult;
        }

        return queryResult;
    }

    public boolean addToWaitlist (String flightNum, String userEmail) {
        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String deletingTable = "INSERT INTO WaitList (ClientEmail, `Departure Date`, `Departure Time`, `Departure Loc`, Class, `Destination Date`, `Destination Loc`, `Destination Time`)\n" +
                    "SELECT Clients.Email, Flight.`Departure Date`, Flight.`Departure Time`, Flight.Departure_Location, Flight.Class, Flight.`Destination Date`, Flight.`Destination Location`, Flight.`Destination Time` \n" +
                    "FROM Clients, Flight\n" +
                    "WHERE Flight.`Flight#`= ?\n" +
                    "AND Clients.Email = ?;";
            PreparedStatement inserter = mainConnection.prepareStatement(deletingTable);
            inserter.setString(1, flightNum);
            inserter.setString(2, userEmail);
            inserter.executeUpdate();
            inserter.close();
            connector.closeConnection();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            connector.closeConnection();
            return false;
        }
    }

    public List<String> getGreatestTotalRevenue() throws SQLException{
        List<String> greatestRevenue = new ArrayList<String>();
        connector.getConnected();
        mainConnection = connector.getMainConnector();
        String query = "Select t1.Name, max(t1.`Total Revenue`) as `Total Revenue` " +
                "from (select Name, sum(`Total Price`) * 0.25 as `Total Revenue` " +
                            "from Ticket Join Clients on Email=ClientEmail group by ClientEmail) as t1";
        PreparedStatement findGreatest = mainConnection.prepareStatement(query);
        ResultSet res = findGreatest.executeQuery();
        while(res.next()){
            greatestRevenue.add(res.getString("Name"));
            greatestRevenue.add(res.getString("Total Revenue"));
        }
        res.close();
        findGreatest.close();
        connector.closeConnection();
        return greatestRevenue;

    }

    public List<List<String>> getSalesReportForMonth(String month) throws SQLException{
        List<List<String>> queryResult = new ArrayList<List<String>>();
        List<String> months = new ArrayList<String>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        String startDate = "";
        String endDate = "";

        int monthIndex = months.indexOf(month) + 1;

        if(monthIndex==2){
            startDate = "2019-02-01";
            endDate = "2019-02-28";
        }
        else if(monthIndex <= 7){
            startDate = "2019-0" + monthIndex + "-01";
            if(monthIndex % 2 != 0){
                endDate = "2019-0" + monthIndex + "-31";
            }
            else{
                endDate = "2019-0" + monthIndex + "-30";
            }
        }
        else if(monthIndex > 7){
            if(monthIndex >= 10){
                startDate = "2019-" + monthIndex + "-01";
            }
            else{
                startDate = "2019-0" + monthIndex + "01";
            }
            if(monthIndex % 2 != 0){
                endDate = "2019-0" + monthIndex + "-30";
            }
            else{
                endDate = "2019-0" + monthIndex + "-31";
            }
        }

        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String query = "Select Flight.`Flight#`, count(Flight.`Flight#`) as `Tickets Sold`, sum(`Total Price`) as `Total Revenue` from Ticket join Flight on\n" +
                    "Flight.`Flight#`=Ticket.`Flight#` where `Departure Date` between ? and ?" +
                    "Group by Flight.`Flight#`";
            PreparedStatement inserter = mainConnection.prepareStatement(query);
            inserter.setString(1, startDate);
            inserter.setString(2, endDate);
            ResultSet res = inserter.executeQuery();
            while (res.next()) {
                List<String> flightReport = new ArrayList<String>();
                flightReport.add(res.getString("Flight#"));
                flightReport.add(res.getString("Tickets Sold"));
                flightReport.add(res.getString("Total Revenue"));
                queryResult.add(flightReport);
            }
            res.close();
            inserter.close();
            connector.closeConnection();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return queryResult;
    }

    public boolean addTicketentry (String clientEmail, String FlightNum, String totalPrice, String type, String roundRef){
        if (roundRef != null){
            try {
                connector.getConnected();
                mainConnection = connector.getMainConnector();
                String deletingTable = "INSERT INTO Ticket (`ClientEmail`, `Flight#`, `Total Price`, `Type`, `Ref`)\n" +
                        "VALUE (?,?,?,?,?)";
                PreparedStatement inserter = mainConnection.prepareStatement(deletingTable);
                inserter.setString(1, clientEmail);
                inserter.setString(2, FlightNum);
                inserter.setString(3, totalPrice);
                inserter.setString(4, type);
                inserter.setString(5, roundRef);
                inserter.executeUpdate();
                inserter.close();
                connector.closeConnection();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                connector.closeConnection();
                return false;
            }
        }
        else {
            try {
                connector.getConnected();
                mainConnection = connector.getMainConnector();
                String deletingTable = "INSERT INTO Ticket (`ClientEmail`, `Flight#`, `Total Price`, `Type`)\n" +
                        "VALUE (?,?,?,?)";
                PreparedStatement inserter = mainConnection.prepareStatement(deletingTable);
                inserter.setString(1, clientEmail);
                inserter.setString(2, FlightNum);
                inserter.setString(3, totalPrice);
                inserter.setString(4, type);
                inserter.executeUpdate();
                inserter.close();
                connector.closeConnection();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                connector.closeConnection();
                return false;
            }

        }
    }

    public int getCapacity (String flightNum){
        try {
            int capacity = 0;
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String getter = "Select 'Capacity' From Flight  where `Flight#` = ?";   //Create string for searching admins
            PreparedStatement stmt = mainConnection.prepareStatement(getter);   //create the actual statement
            stmt.setString(1, flightNum);    //Adding the first parameter
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                capacity = res.getInt("Capacity");
            }
            return capacity;
        }catch (Exception e ){
            e.printStackTrace();
            return -1;
        }
    }

    public void updateCapacity (String flightNum, String Capacity){
        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String search = "UPDATE Flight" + " SET Flight.Capacity = ? " + " WHERE Flight.`Flight#` = ?";   //Create string for searching admins
            PreparedStatement stmt = mainConnection.prepareStatement(search);   //create the actual statement
            stmt.setString(1, Capacity);//Adding the first parameter
            stmt.setString(2, flightNum);
            stmt.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public List<List<String>> querySpecFlight (String FlightNum){
        List<List<String>> fullList = new ArrayList<List<String>>();
        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String getter = "Select * From Flight  where `Flight#` = ?";   //Create string for searching admins
            PreparedStatement stmt = mainConnection.prepareStatement(getter);   //create the actual statement
            stmt.setString(1, FlightNum);    //Adding the first parameter
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                List<String> data = new ArrayList<String>();
                data.add(res.getString("Flight#"));
                data.add(res.getString("Departure Date"));
                data.add(res.getString("Departure Time"));
                data.add(res.getString("Departure_Location"));
                data.add(res.getString("Destination Date"));
                data.add(res.getString("Destination Time"));
                data.add(res.getString("Destination Location"));
                data.add(res.getString("Class"));
                data.add(res.getString("Airline"));
                data.add(res.getString("FlightID"));
                data.add(res.getString("Price"));
                fullList.add(data);
            }
            stmt.close();
            res.close();
            connector.closeConnection();
            return fullList;
        }catch (Exception e ){
            e.printStackTrace();
            return fullList;
        }
    }

    public List<List<String>> getCustomersOnWaitlist(String flightNum){
        List<List<String>> fullList = new ArrayList<List<String>>();
        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String getter = "Select Clients.Name, Email \n" +
                    "From Clients join WaitList\n" +
                    "on Clients.Email = WaitList.ClientEmail\n" +
                    "where WaitList.`Flight#` = ?";   //Create string for searching admins
            PreparedStatement stmt = mainConnection.prepareStatement(getter);   //create the actual statement
            stmt.setString(1, flightNum);    //Adding the first parameter
            ResultSet res = stmt.executeQuery();
            while(res.next()){
                List<String> data = new ArrayList<String>();
                data.add(res.getString("Name"));
                data.add(res.getString("Email"));
                fullList.add(data);
            }
            stmt.close();
            res.close();
            connector.closeConnection();
            return fullList;
        }catch (Exception e ){
            e.printStackTrace();
            return fullList;
        }
    }

}

	public int updateCapacity (String flightNum){
		try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String search = "UPDATE Flight" + " SET Flight.Capacity = ? " + " WHERE Flight.`Flight#` = ?";   //Create string for searching admins
            PreparedStatement stmt = mainConnection.prepareStatement(search);   //create the actual statement
            stmt.setString(1, Capacity);//Adding the first parameter
            stmt.setString(2, flightNum);
            stmt.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }

	}
	
    public int addToAirport (String AirportID){
        try {
            connector.getConnected();
            mainConnection = connector.getMainConnector();
            String getter = "INSERT INTO Airport (AirportID) " + " VALUE (?)";   //Create string for searching admins
            PreparedStatement stmt = mainConnection.prepareStatement(getter);   //create the actual statement
            stmt.setString(1, AirportID);    //Adding the first parameter
            stmt.executeUpdate();
            return 1;

        }catch (Exception e ){
            e.printStackTrace();
            return -1;
        }
    }


}

	

//customer rep has to choose an airline from a drop-down menu first (before adding airplane)
	public int addToAirplane (String CraftID){
	    try {
	        connector.getConnected(); //asdflkaj
	        mainConnection = connector.getMainConnector();
	        String getter = "INSERT INTO Airplanes (CraftID, Airlines_Airline_Code)" + "VALUE (?,?))";   //Create string for searching admins
	        PreparedStatement stmt = mainConnection.prepareStatement(getter);   //create the actual statement
	        stmt.setString(1, CraftID);    //Adding the first parameter
	        stmt.executeUpdate();
	        return 1;
	        
	    }catch (Exception e ){
	        e.printStackTrace();
	        return -1;
	    }
	}
}
	
	
	
//Test merge

