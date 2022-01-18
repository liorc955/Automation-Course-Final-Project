package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class InventoryPage {

    @FindBy (how = How.CLASS_NAME , using = "product_sort_container")
    public WebElement product_sort;
    @FindBy(how = How.CLASS_NAME, using = "inventory_item")
    public List<WebElement> inventory_item;
    @FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
    public List<WebElement> inventory_item_name;
    @FindBy(how = How.CLASS_NAME, using = "inventory_item_desc")
    public List<WebElement> inventory_item_desc;
    @FindBy(how = How.CLASS_NAME, using = "inventory_item_price")
    public List<WebElement> inventory_item_price;
    public By btn_removeItem_locator = By.cssSelector("button[name*='remove']");
    public By btn_addItem_locator = By.cssSelector("button[name*='add-to-cart']");
}
