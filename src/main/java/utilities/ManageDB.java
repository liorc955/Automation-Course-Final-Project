package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {

    /* ---------------------------------------------------
        Method Name: openConnection
        Method Description: This method opens a connection with the MySQL DB.
        con - initializes the connection to the DB.
        stmt - initializes the query to the DB.
        Method Parameters: String dbUrl, String dbUser, String dbPass
        Method Return: void
        --------------------------------------------------- */
    public static void openConnection(String dbUrl, String dbUser, String dbPass){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Can not connect to the DB server");
            System.out.println(e);
        }
    }

    /* ---------------------------------------------------
        Method Name: closeConnection
        Method Description: This method closes the connection to the MySQL DB.
        Method Parameters: void
        Method Return: void
        --------------------------------------------------- */
    public static void closeConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Can not close DB server");
            System.out.println(e);
        }
    }
}
