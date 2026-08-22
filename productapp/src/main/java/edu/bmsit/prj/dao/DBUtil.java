package edu.bmsit.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
    private static String DRIVER = "";
    private static String URL = "";
    private  static String USER = "";
    private static String PWD = "";

    static  {
        ResourceBundle bundle = ResourceBundle.getBundle("database");
        DRIVER = bundle.getString("DRIVER").trim();
        URL = bundle.getString("URL").trim();
        USER = bundle.getString("USER").trim();
        PWD = bundle.getString("PWD").trim();

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PWD);
    }

    public static void closeConnection(Connection con) {
        if(con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
