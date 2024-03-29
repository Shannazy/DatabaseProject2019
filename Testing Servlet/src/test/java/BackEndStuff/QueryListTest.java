package BackEndStuff;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QueryListTest {

    @Test
    void searchAdmins() {
        DatabaseConnection testingCon = new DatabaseConnection();
        QueryList testingSearch = new QueryList(testingCon);
        assertEquals(true, testingSearch.searchAdmins("Shazidul Islam", "si194"));

    }

    @Test
    void registerClient() {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList testingentry = new QueryList(tester);
        assertEquals(true, testingentry.registerClient("BasicEmail.com", "Fake Name", "8254176529", "2019-11-17", "NotRealPass", "1998-05-18"));
    }


    @Test
    void initialOneWayTicket() {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> myarray = searchForTicket.initialOneWayTicket("2019-12-12", "JFK", "");
        for (List<String> part1 : myarray) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }


    @Test
    void getAllReservation() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> mytest = searchForTicket.getAllReservations("BasicEmail.com");
        for (List<String> part1 : mytest) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void getComingReservations() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> mytest = searchForTicket.getComingReservations("BasicEmail.com");
        for (List<String> part1 : mytest) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void getPastReservation() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> mytest = searchForTicket.getPastReservation("BasicEmail.com");
        for (List<String> part1 : mytest) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void getDeparturesFromAirport() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> departurList = searchForTicket.getDeparturesFromAirport("JFK");
        for (List<String> part1 : departurList) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void getArrivalToAirport() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> arrivalList = searchForTicket.getArrivalToAirport("LGA");
        for (List<String> part1 : arrivalList) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void getResWithAirport() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> resWithAirport = searchForTicket.getResWithAirport("BasicEmail.com", "JFK");
        for (List<String> part1 : resWithAirport) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void adminDelete() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        System.out.println(searchForTicket.adminDelete("Clients","as2591@scarletmail.rutgers.edu"));
    }

    @Test
    void flexableNoFilter() {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> arrivalList = searchForTicket.flexableNoFilter("2019-12-15", "JFK", "LAX");
        for (List<String> part1 : arrivalList) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void dynamicQuery() {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> arrivalList = searchForTicket.dynamicQuery("2019-12-12", "JFK",
                "LAX", null, null, "AA", true, "Price" );
        for (List<String> part1 : arrivalList) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void airportList() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<String> arrivalList = searchForTicket.airportList();
        for (String part1 : arrivalList) {
            System.out.println(part1+ "\n");
        }
    }

    @Test
    void querySpecFlight() {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> arrivalList = searchForTicket.querySpecFlight("2" );
        for (List<String> part1 : arrivalList) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void addTicketentry() {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        searchForTicket.addTicketentry("BasicEmail.com","2","650","One-Way",null);
    }

    @Test
    void getSalesReportForMonth() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> arrivalList = searchForTicket.getSalesReportForMonth("December" );
        for (List<String> part1 : arrivalList) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }

    }

    @Test
    void getCustomersOnWaitlist() {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> arrivalList = searchForTicket.getCustomersOnWaitlist("0" );
        for (List<String> part1 : arrivalList) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void getSalesReport() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> arrivalList = searchForTicket.getSalesReport("airline", "AA" );
        for (List<String> part1 : arrivalList) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }

    }

    @Test
    void addToAirplane() {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        searchForTicket.addToAirplane("200","AA");
    }

    @Test
    void getGreatestTotalFlightRevenue() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<String> arrivalList = searchForTicket.getGreatestTotalFlightRevenue();
        for (String part1 : arrivalList) {
            System.out.print(part1 + " ");
        }
    }

    @Test
    void getSpecificReservations() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> arrivalList = searchForTicket.getSpecificReservations("Client", "BasicEmail.com");
        for (List<String> part1 : arrivalList) {
            for (String runner : part1) {
                System.out.print(runner + " ");
            }
            System.out.println();
        }
    }

    @Test
    void editFlight() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        searchForTicket.editReservation("7","4");
    }
}

