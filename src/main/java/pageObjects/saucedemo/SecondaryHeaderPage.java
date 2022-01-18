package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SecondaryHeaderPage {
    @FindBy(how = How.CLASS_NAME, using = "title")
    public WebElement header_secondary_title;
    @FindBy(how = How.ID, using = "back-to-products")
    public WebElement back_to_products_btn;
}
