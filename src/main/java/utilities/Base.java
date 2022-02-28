package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.mortgage.MainPage;
import pageObjects.saucedemo.*;

public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected static Screen screen;
    protected static DesiredCapabilities dc = new DesiredCapabilities();

    //Web
    protected static WebDriver driver;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static TouchAction touchAction;

    // Web Page Objects
    protected static LoginPage sauceDemoLogin;
    protected static InventoryPage sauceDemoInventory;
    protected static LeftMenuPage sauceDemoLeftMenu;
    protected static SecondaryHeaderPage sauceDemoSecondaryHeader;
    protected static PrimaryHeaderPage sauceDemoPrimaryHeader;
    protected static CartPage sauceDemoCartPage;
    protected static InventoryItemPage sauceDemoInventoryItem;

    // Mobile Page Objects
    protected static MainPage mortgageMain;
}
