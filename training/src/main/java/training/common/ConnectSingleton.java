package training.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectSingleton {
    private static Connection instance = null;
    private ConnectSingleton() {
    }

    public static Connection getInstance(String dbName) throws SQLException {
         String url = "jdbc:mysql://localhost:3306/" + dbName;

        if (instance == null) {
            instance = DriverManager.getConnection(url, FinalCommon.USERNAME, FinalCommon.PASSWORD);
        }
        return instance;
    }
}
