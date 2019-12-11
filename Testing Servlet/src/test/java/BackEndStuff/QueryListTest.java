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
    void getUserInfo() throws SQLException {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        UserInfo mytest = searchForTicket.getUserInfo("BasicEmail.com");
        System.out.println(mytest.Phone);
        System.out.println(mytest.Creation_Date);
        System.out.println(mytest.DOB);

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
}
