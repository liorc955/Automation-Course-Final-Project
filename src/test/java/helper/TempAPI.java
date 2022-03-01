package helper;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TempAPI {

    private RequestSpecification httpRequest;
    private Response response;
    private String url = "https://bookstore.toolsqa.com/";

    @BeforeClass
    public void beforeClass(){
        RestAssured.baseURI = url;
        httpRequest = RestAssured.given();
        httpRequest.contentType(ContentType.JSON);
        httpRequest.header("Content-Type","application/json");
    }

    @Test
    public void postTest(){
        JSONObject params = new JSONObject();
        params.put("userName","liorco");
        params.put("password","Aa123456!");
        httpRequest.body(params.toJSONString());
        response = httpRequest.post("/Account/v1/User");
        response.prettyPrint();
    }

    @Test
    public void getTest(){
        httpRequest.auth().preemptive().basic("liorco","Aa123456!");
        response = httpRequest.get("BookStore/v1/Book?ISBN=9781449325862");
        response.prettyPrint();
    }

}
