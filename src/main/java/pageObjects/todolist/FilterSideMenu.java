package pageObjects.todolist;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class FilterSideMenu {
    @FindBy (how = How.CSS , using = "input[placeholder='Create a task']")
    public WebElement txt_create;
    @FindBy (how = How.CLASS_NAME , using = "view_2Ow90")
    public List<WebElement> list_tasks;
    @FindBy (how = How.CLASS_NAME, using = "destroy_19w1q")
    public WebElement btn_delete;
    @FindBy (how = How.CLASS_NAME, using = "toggleVisibilityPanel_hNPyc")
    public WebElement open_filter_sideMenu;
    @FindBy (how = How.XPATH, using = "//div[@class='toggleVisibilityPanel_hNPyc isVisible_1VByM']")
    public WebElement close_filter_sideMenu;
    @FindBy (how = How.XPATH, using = "//*[@class='filterWrapper_1TK4M']/button[contains(text(),'All')]")
    public WebElement btn_date_all_filter;
    @FindBy (how = How.XPATH, using = "//*[@class='filterWrapper_1TK4M']/button[contains(text(),'Selected Date')]")
    public WebElement btn_date_selectedDate_filter;
    @FindBy (how = How.XPATH, using = "//*[@class='statusWrapper_fkjww']/button[contains(text(),'All')]")
    public WebElement btn_status_all_filter;
    @FindBy (how = How.XPATH, using = "//*[@class='statusWrapper_fkjww']/button[contains(text(),'Todo')]")
    public WebElement btn_status_todo_filter;
    @FindBy (how = How.XPATH, using = "//*[@class='statusWrapper_fkjww']/button[contains(text(),'Completed')]")
    public WebElement btn_status_completed_filter;
    @FindBy (how = How.XPATH, using = "//div[@class='wrapper_3Kpfj tagsWrapper_jJPK-']//span[@class='tag_21fhY']")
    public List<WebElement> list_color_filter;
}
