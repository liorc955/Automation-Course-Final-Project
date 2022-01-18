package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PrimaryHeaderPage {
    @FindBy(how = How.CLASS_NAME , using = "app_logo")
    public WebElement app_logo;
    @FindBy(how = How.ID , using = "react-burger-menu-btn")
    public WebElement burger_menu;
    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
    public WebElement shopping_cart_link;
    @FindBy(how = How.CLASS_NAME , using = "shopping_cart_badge")
    public WebElement shopping_cart_badge;
}
