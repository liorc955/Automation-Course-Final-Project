package sanity;



import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.ManageDDT;
import workflows.WebFlows;
import java.lang.reflect.Method;



@Listeners(utilities.Listeners.class)
public class SauceDemoWeb extends CommonOps {

    @BeforeMethod
    public void before(){
        WebFlows.login("standard_user","secret_sauce");
    }


    @Test(description = "Test01 - Verify Title")
    @Description("This test verifies the secondary header title")
    public void test01_verifyTitle(){
        Verifications.verifyTextInElement(sauceDemoSecondaryHeader.header_secondary_title, "PRODUCTS");
    }

    @Test(description = "Test02 - Verify Items Number")
    @Description("This test verifies the amount of the items on the inventory page")
    public  void test02_verifyItemsNumber(){
        Verifications.verifyNumberOfElements(sauceDemoInventory.inventory_item,6);
    }

    @Test(description = "Test03 - Add and Remove Item Testing")
    @Description("This test verifies the functionality of adding and removing items from the inventory")
    public void test03_add_and_removeItemsFromInventory(){
        WebFlows.addItem("Sauce Labs Backpack");
        WebFlows.addItem("Sauce Labs Bolt T-Shirt");
        WebFlows.removeItem("Sauce Labs Bolt T-Shirt");
        Verifications.verifyTextInElement(sauceDemoPrimaryHeader.shopping_cart_badge, "1");
        WebFlows.removeItem("Sauce Labs Backpack");
    }

    @Test(description = "Test04 - Verify low to high sorting items")
    @Description("This test verifies the functionality of low to high sorting items")
    public void test04_verify_low_to_high_sortingItems(){
        WebFlows.sortInventoryItems("Price (low to high)");
        Verifications.verifyItemsPriceAfterLowToHighSorting(sauceDemoInventory.inventory_item_price);
    }

    @Test(description = "Test05 - Verify visibility of items")
    @Description("This test verifies the visibility of the items on the inventory page using softAssertion")
    public void test05_verify_AllElementsDisplay(){
        Verifications.verifyElementsDisplay(sauceDemoInventory.inventory_item);
    }

    @Test(description = "Test06 - Verify Primary Header Logo")
    @Description("This test verifies the visualization of the primary header logo using Sikuli")
    public void test06_verify_visualization_primary_header_logo(Method method){
        Verifications.visualElement(method.getName());
    }


    @Test(description = "Test07 - Verify Item Exists In Cart", dataProvider = "data-provider", dataProviderClass = ManageDDT.class)
    @Description("This test verifies the existence of an item in a cart using DDT")
    public void test07_verify_product_exists_inCart(String itemName){
        WebFlows.addItem(itemName);
        UIActions.click(sauceDemoPrimaryHeader.shopping_cart_link);
        Verifications.verifyElementExistsInElementsByTitle(sauceDemoCartPage.cart_items_name,itemName);
    }
}
