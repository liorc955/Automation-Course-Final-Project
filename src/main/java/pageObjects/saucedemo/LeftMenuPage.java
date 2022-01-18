package pageObjects.saucedemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class LeftMenuPage {
    @FindBy(how = How.CSS, using = ".bm-item-list a")
    public List<WebElement> sidebar_links;
    @FindBy(how = How.ID , using = "inventory_sidebar_link")
    public WebElement inventory_sidebar_link;
    @FindBy(how = How.ID , using = "about_sidebar_link")
    public WebElement about_sidebar_link;
    @FindBy(how = How.ID , using = "logout_sidebar_link")
    public WebElement logout_sidebar_link;
    @FindBy(how = How.ID , using = "reset_sidebar_link")
    public WebElement reset_sidebar_link;
    @FindBy(how = How.ID , using = "react-burger-cross-btn")
    public WebElement closeBtn;
}
