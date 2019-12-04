import BackEndCode.Database_Connections;
import BackEndCode.QueryList;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class QueryListTest {

    @Test
    void searchAdmins() throws SQLException {
        Database_Connections testingConnection = new Database_Connections();
        QueryList myList = new QueryList(testingConnection);
        boolean isAdmin = myList.searchAdmins("Shaz6ul Islam", "si194");
        assertEquals(false, isAdmin);

    }

    @Test
    void searchCLients() {
        Database_Connections testingConnection = new Database_Connections();
        QueryList myList = new QueryList(testingConnection);
        boolean isAdmin = myList.searchCLients("testingEmail.com", "testingPass");
        assertEquals(true, isAdmin);
    }
}