package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.mortgage.MainPage;
import pageObjects.mortgage.SavedPage;
import pageObjects.saucedemo.*;


public class ManagePages extends Base {

    /* ---------------------------------------------------
        Method Name: initSauceDemo
        Method Description: This method initializes the page objects elements for the SauceDemo website.
        Method Parameters: void
        Method Return: void
        --------------------------------------------------- */
    public static void initSauceDemo(){
        sauceDemoLogin = PageFactory.initElements(driver, LoginPage.class);
        sauceDemoInventory = PageFactory.initElements(driver, InventoryPage.class);
        sauceDemoLeftMenu = PageFactory.initElements(driver, LeftMenuPage.class);
        sauceDemoSecondaryHeader = PageFactory.initElements(driver, SecondaryHeaderPage.class);
        sauceDemoPrimaryHeader = PageFactory.initElements(driver, PrimaryHeaderPage.class);
        sauceDemoCartPage = PageFactory.initElements(driver, CartPage.class);
        sauceDemoInventoryItem = PageFactory.initElements(driver, InventoryItemPage.class);
    }

    /* ---------------------------------------------------
        Method Name: initMortgage
        Method Description: This method initializes the page objects elements for the Mortgage Mobile App.
        Method Parameters: void
        Method Return: void
        --------------------------------------------------- */
    public static void initMortgage(){
        mortgageMain = new MainPage(mobileDriver);
        mortgageSaved = new SavedPage(mobileDriver);
    }

    /* ---------------------------------------------------
        Method Name: initTodo
        Method Description: This method initializes the page objects elements for the to do list electron app.
        Method Parameters: void
        Method Return: void
        --------------------------------------------------- */
    public static void initTodo() {
        todoMain = PageFactory.initElements(driver, pageObjects.todolist.MainPage.class);
        todoFilterSideMenu = PageFactory.initElements(driver,pageObjects.todolist.FilterSideMenu.class);
    }

    /* ---------------------------------------------------
        Method Name: initCalculator
        Method Description: This method initializes the page objects elements for the calculator desktop app.
        Method Parameters: void
        Method Return: void
        --------------------------------------------------- */
    public static void initCalculator(){
        calcMain = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
