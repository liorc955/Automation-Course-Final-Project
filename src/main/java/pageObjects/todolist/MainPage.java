package pageObjects.todolist;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {
    @FindBy (how = How.CSS , using = "input[placeholder='Create a task']")
    public WebElement txt_create;
    @FindBy (how = How.CLASS_NAME , using = "view_2Ow90")
    public List<WebElement> list_tasks;
    @FindBy (how = How.CLASS_NAME , using = "label_5i8SP")
    public List<WebElement> txt_list_tasks;
    @FindBy (how = How.CLASS_NAME, using = "destroy_19w1q")
    public WebElement btn_delete;
    @FindBy(how = How.CSS, using = "label.toggleIconsWrapper_2kpi8")
    public List<WebElement> btn_mark_completed;
    @FindBy (how = How.CLASS_NAME, using = "toggleVisibilityPanel_hNPyc")
    public WebElement btn_open_filter_sideMenu;
    @FindBy (how = How.XPATH, using = "//*[@class='toggleVisibilityPanel_hNPyc isVisible_1VByM']")
    public WebElement btn_close_filter_sideMenu;
    @FindBy (how = How.XPATH, using = "//div[@class='wrapper_3Kpfj vertical_di1oV tagList_2NRe0']//span[@class='tag_21fhY']")
    public List<WebElement> list_color_marks;
    @FindBy (how = How.CLASS_NAME, using = "topWrapper_2caNE")
    public WebElement btn_color_list;
}
