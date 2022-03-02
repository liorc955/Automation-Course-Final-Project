package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("Get Credentials From DB")
    public static List<String> getCredentials(String query){
        List<String> credentials = new ArrayList<>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
        } catch (SQLException e) {
            System.out.println("Error Occurred While Fetching Table Data");
            e.printStackTrace();
        }
        return credentials;
    }
}
