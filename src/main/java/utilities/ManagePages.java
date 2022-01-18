package utilities;

import org.openqa.selenium.support.PageFactory;



public class ManagePages extends Base {

    public static void initSauceDemo(){
        sauceDemoLogin = PageFactory.initElements(driver,pageObjects.saucedemo.LoginPage.class);
        sauceDemoInventory = PageFactory.initElements(driver,pageObjects.saucedemo.InventoryPage.class);
        sauceDemoLeftMenu = PageFactory.initElements(driver,pageObjects.saucedemo.LeftMenuPage.class);
        sauceDemoSecondaryHeader = PageFactory.initElements(driver,pageObjects.saucedemo.SecondaryHeaderPage.class);
        sauceDemoPrimaryHeader = PageFactory.initElements(driver,pageObjects.saucedemo.PrimaryHeaderPage.class);
        sauceDemoCartPage = PageFactory.initElements(driver,pageObjects.saucedemo.CartPage.class);
        sauceDemoInventoryItem = PageFactory.initElements(driver,pageObjects.saucedemo.InventoryItemPage.class);
    }
}
