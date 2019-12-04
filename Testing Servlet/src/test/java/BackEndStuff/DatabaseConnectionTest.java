package BackEndStuff;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionTest {

    @org.junit.jupiter.api.Test
    void getConnected() {
        DatabaseConnection testConnector = new DatabaseConnection();
        assertEquals(true, testConnector.getConnected());
        testConnector.closeConnection();
    }
}