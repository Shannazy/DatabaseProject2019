import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class QueryListTest {

    @Test
    void searchAdmins() throws SQLException {
        Database_Connections testingConnection = new Database_Connections();
        QueryList myList = new QueryList(testingConnection);
        boolean isAdmin = myList.searchAdmins("Shazidul Ilam", "si194");
        assertEquals(false, isAdmin);

    }
}