package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.mortgage.MainPage;
import pageObjects.saucedemo.*;


public class ManagePages extends Base {

    public static void initSauceDemo(){
        sauceDemoLogin = PageFactory.initElements(driver, LoginPage.class);
        sauceDemoInventory = PageFactory.initElements(driver, InventoryPage.class);
        sauceDemoLeftMenu = PageFactory.initElements(driver, LeftMenuPage.class);
        sauceDemoSecondaryHeader = PageFactory.initElements(driver, SecondaryHeaderPage.class);
        sauceDemoPrimaryHeader = PageFactory.initElements(driver, PrimaryHeaderPage.class);
        sauceDemoCartPage = PageFactory.initElements(driver, CartPage.class);
        sauceDemoInventoryItem = PageFactory.initElements(driver, InventoryItemPage.class);
    }

    public static void initMortgage(){
        mortgageMain = new MainPage(mobileDriver);
    }
}
