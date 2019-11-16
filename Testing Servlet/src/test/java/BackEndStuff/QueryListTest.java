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
}