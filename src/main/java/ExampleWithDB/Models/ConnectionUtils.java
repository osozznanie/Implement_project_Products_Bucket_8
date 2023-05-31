package ExampleWithDB.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnectionUtils {
    private static String USER_NAME = "root";
    private static String USER_PASSWORD = "qwerty666";
    private static String URL = "jdbc:mysql://localhost/magazine_shop?serverTimezone=" + TimeZone.getDefault().getID();

    public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        Class.forName ("com.mysql.cj.jdbc.Driver").newInstance();
        return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
    }


}
