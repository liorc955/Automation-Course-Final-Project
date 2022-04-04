package pageObjects.mortgage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class SavedPage {

    private AppiumDriver mobileDriver;

    public SavedPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(xpath = "//*[@id='lvSavedCalcs']/*[@class='android.widget.LinearLayout']")
    public List<AndroidElement> saved_mortgage_list;
    @AndroidFindBy(id = "btnDel")
    public AndroidElement btn_delete_saved_mortgage;
    @AndroidFindBy(id = "button1")
    public AndroidElement btn_accept_alert;
}
