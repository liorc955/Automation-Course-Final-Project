package workflows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import utilities.CommonOps;

import java.util.ArrayList;


public class ApiFlows extends CommonOps {

    @Step("Business Flow: Get Book Property")
    public static String  getBookProperty(String jPath){
        ApiActions.get("BookStore/v1/Books");
        return ApiActions.extractFromJSON(jPath);
    }

    @Step("Business Flow: Post a New Book")
    public static void postNewBook(String isbn){
        ArrayList<JSONObject> collectionOfIsbns = new ArrayList<>();
        JSONObject bookIsbn = new JSONObject();
        bookIsbn.put("isbn",isbn);
        collectionOfIsbns.add(bookIsbn);
        params.put("userId", getData("UserId"));
        params.put("collectionOfIsbns", collectionOfIsbns);
        ApiActions.post("BookStore/v1/Books");
    }

    @Step("Business Flow: Update a Book")
    public static void updateBook(String oldBookIsbn, String newBookIsbn){
        params.put("userId",getData("UserId"));
        params.put("isbn",newBookIsbn);
        ApiActions.put(String.format("BookStore/v1/Books/%s",oldBookIsbn));
    }

    @Step("Business Flow: Delete All user's books")
    public static void deleteBooks(){
        ApiActions.delete(String.format("BookStore/v1/Books?UserId=%s",getData("UserId")));
    }

    @Step("Business Flow: Get Status Code")
    public static int getStatusCode(){
        return response.getStatusCode();
    }


}
