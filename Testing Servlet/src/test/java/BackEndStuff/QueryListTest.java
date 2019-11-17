package BackEndStuff;

import org.junit.jupiter.api.Test;

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
}