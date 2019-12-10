package BackEndStuff;

import org.junit.jupiter.api.Test;

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
        assertEquals(true, testingentry.registerClient("BasicEmail.com","Fake Name", "8254176529","2019-11-17","NotRealPass","1998-05-18"));
    }


    @Test
    void initialOneWayTicket() {
        DatabaseConnection tester = new DatabaseConnection();
        QueryList searchForTicket = new QueryList(tester);
        List<List<String>> myarray = searchForTicket.initialOneWayTicket("2019-12-12","JFK","LAX");
        for (List<String> part1 : myarray){
            for (String runner : part1){
                System.out.print(runner+ " ");
            }
            System.out.println();
        }
    }
}