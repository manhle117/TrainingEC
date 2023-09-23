package training.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static Connection connection;

    private static final String  USER = "root";
    private static final String PASSWORD = "manhle2120";

    //dư throws
    //Chuyển thành singleton pattern
    public static Connection getConnection(String dbName) {
        try {
            String url = "jdbc:mysql://localhost:3306/" + dbName;


            return  connection = DriverManager.getConnection(url, USER, PASSWORD);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void closeConnection(AutoCloseable... autoCloseables) {
        for (AutoCloseable closeable : autoCloseables) {
            try {
                if (closeable != null) {
                    closeable.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
