package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;

public class ApiActions extends CommonOps {

    @Step("Get Data From Server")
    public static void get(String paramValues){
        response = httpRequest.get(paramValues);
    }

    @Step("Post Data To Server")
    public static void post(String resource){
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response =  httpRequest.post(resource);
    }

    @Step("Update Data in Server")
    public static void put(String resource){
        httpRequest.header("Content-Type","application/json");
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
    }

    @Step("Delete Data from Server")
    public static void delete(String resource){
        response = httpRequest.delete(resource);
    }

    @Step("Extract Value From JSON")
    public static String extractFromJSON(String path){
        jp = response.jsonPath();
        return jp.getString(path);
    }



}
