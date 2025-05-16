import java.sql.*;

public class SQLConnection {
    private Connection connection;

    SQLConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbex", "test", "1234");
    }

    Connection getConnection() {
        return connection;
    }
}
