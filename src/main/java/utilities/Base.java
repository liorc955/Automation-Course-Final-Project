package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.windows.WindowsDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.mortgage.MainPage;
import pageObjects.saucedemo.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    // General
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    public static String platform;
    public static String ddtFilePath;

    // Rest API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    // Web
    protected static WebDriver driver;

    // Mobile
    protected static AppiumDriver mobileDriver;
    protected static TouchAction touchAction;

    // Database
    protected static ResultSet rs;
    protected static Connection con;
    protected static Statement stmt;

    // Web Page Objects
    protected static LoginPage sauceDemoLogin;
    protected static InventoryPage sauceDemoInventory;
    protected static LeftMenuPage sauceDemoLeftMenu;
    protected static SecondaryHeaderPage sauceDemoSecondaryHeader;
    protected static PrimaryHeaderPage sauceDemoPrimaryHeader;
    protected static CartPage sauceDemoCartPage;
    protected static InventoryItemPage sauceDemoInventoryItem;

    // Mobile Page Objects
    protected static pageObjects.mortgage.MainPage mortgageMain;
    protected static pageObjects.mortgage.SavedPage mortgageSaved;

    // Electron Page Objects
    protected static pageObjects.todolist.MainPage todoMain;
    protected static pageObjects.todolist.FilterSideMenu todoFilterSideMenu;

    // Desktop Page Objects
    protected static pageObjects.calculator.MainPage calcMain;
}
