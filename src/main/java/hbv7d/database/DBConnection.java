package hbv7d.database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Þessi klasi sér um að tengjast við gagnagrunn, ef enginn gagnagrunnur er til þá skal hann búa hann til.
 */
public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.sqlite.JDBC");
                String filePAbsPath = System.getProperty("user.dir") + "\\" + "DayTours.db";
                connection = DriverManager.getConnection("jdbc:sqlite:" +filePAbsPath);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}
