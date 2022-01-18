package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;



public class WebFlows extends CommonOps {

    @Step("Business Flow: Login")
    public static void login(String userName, String password){
        UIActions.updateText(sauceDemoLogin.txt_userName,userName);
        UIActions.updateText(sauceDemoLogin.txt_password,password);
        UIActions.click(sauceDemoLogin.loginBtn);
    }

    @Step("Business Flow: Add Item")
    public static void addItem(String itemName){
        int indexOfElement = UIActions.getIndexOfElementByTitle(itemName,sauceDemoInventory.inventory_item_name);
        WebElement itemElement = sauceDemoInventory.inventory_item.get(indexOfElement);
        UIActions.click(itemElement.findElement(sauceDemoInventory.btn_addItem_locator));
    }

    @Step("Business Flow: Remove Item")
    public static void removeItem(String itemName){
        int indexOfElement = UIActions.getIndexOfElementByTitle(itemName,sauceDemoInventory.inventory_item_name);
        WebElement itemElement = sauceDemoInventory.inventory_item.get(indexOfElement);
        UIActions.click(itemElement.findElement(sauceDemoInventory.btn_removeItem_locator));
    }

    @Step("Business Flow: Sort Inventory Items")
    public static void sortInventoryItems(String sortName){
        UIActions.click(sauceDemoInventory.product_sort);
        UIActions.updateDropDown(sauceDemoInventory.product_sort, sortName, "text");
    }


    @Step("Business Flow: Remove Item From Cart")
    public static void removeItemFromCart(String itemName){
        int indexOfElement = UIActions.getIndexOfElementByTitle(itemName,sauceDemoCartPage.cart_items_name);
        WebElement itemElement = sauceDemoCartPage.cart_items.get(indexOfElement);
        UIActions.click(itemElement.findElement(sauceDemoCartPage.btn_remove_item_cart_locator));
    }


}
