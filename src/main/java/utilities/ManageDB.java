package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ManageDB extends CommonOps {

    public static void openConnection(String dbUrl, String dbUser, String dbPass){
        try {
            con = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            stmt = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Can not connect to the DB server");
            System.out.println(e);
        }
    }

    public static void closeConnection(){
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Can not close DB server");
            System.out.println(e);
        }
    }
}
