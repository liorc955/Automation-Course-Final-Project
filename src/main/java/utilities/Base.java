package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions actions;
    protected static SoftAssert softAssert;
    protected static Screen screen;

    // Page Objects
    protected static pageObjects.saucedemo. LoginPage sauceDemoLogin;
    protected static pageObjects.saucedemo.InventoryPage sauceDemoInventory;
    protected static pageObjects.saucedemo.LeftMenuPage sauceDemoLeftMenu;
    protected static pageObjects.saucedemo.SecondaryHeaderPage sauceDemoSecondaryHeader;
    protected static pageObjects.saucedemo.PrimaryHeaderPage sauceDemoPrimaryHeader;
    protected static pageObjects.saucedemo.CartPage sauceDemoCartPage;
    protected static pageObjects.saucedemo.InventoryItemPage sauceDemoInventoryItem;
}
