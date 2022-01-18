package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InventoryItemPage {

    @FindBy(how= How.CLASS_NAME, using = "inventory_details_img")
    public WebElement inventory_details_img;
    @FindBy(how = How.CSS, using = "div[class='inventory_details_name large_size']")
    public WebElement inventory_details_name;
    @FindBy(how = How.CSS , using = "div[class='inventory_details_desc large_size']")
    public  WebElement inventory_details_desc;
    @FindBy(how = How.CLASS_NAME, using = "inventory_details_price")
    public WebElement inventory_details_price;
    @FindBy(how = How.CSS, using = "button[name*='remove']")
    public WebElement btn_removeItem;
    @FindBy(how = How.CSS, using = "button[name*='add-to-cart']")
    public WebElement btn_addItem;
}
