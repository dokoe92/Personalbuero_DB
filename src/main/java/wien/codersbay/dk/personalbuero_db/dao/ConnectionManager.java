package wien.codersbay.dk.personalbuero_db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private ConnectionManager() {

    }

    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/personalbuero?user=root");
        }
        return connection;
    }

}
