package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class CartPage {
    @FindBy(how= How.CLASS_NAME, using = "cart_item")
    public List<WebElement> cart_items;
    @FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
    public List<WebElement> cart_items_name;
    @FindBy(how = How.ID , using = "continue-shopping")
    public  WebElement continue_shopping_btn;
    @FindBy(how = How.ID, using = "checkout")
    public WebElement btn_checkout;
    public By btn_remove_item_cart_locator = By.cssSelector("button[class='btn btn_secondary btn_small cart_button']");
}
