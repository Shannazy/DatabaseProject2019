import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Database_ConnectionsTest {

    @Test
    void getConnected() {
        Database_Connections myConnection = new Database_Connections();
        assertEquals(true, myConnection.getConnected());
        myConnection.closeConnection();
    }

}