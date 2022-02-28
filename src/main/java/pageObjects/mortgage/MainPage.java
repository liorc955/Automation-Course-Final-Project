package pageObjects.mortgage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;


public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(3)), this);
    }

    @AndroidFindBy(id = "etAmount")
    public AndroidElement txt_amount;
    @AndroidFindBy(id = "etTerm")
    public AndroidElement txt_term;
    @AndroidFindBy(id = "etRate")
    public AndroidElement txt_rate;
    @AndroidFindBy(id = "add_schedule_text")
    public AndroidElement btn_calculate;
    @AndroidFindBy(id = "add_schedule_icon")
    public AndroidElement icon_schedule;
    @AndroidFindBy(id = "btnSave")
    public AndroidElement btn_save;
    @AndroidFindBy(id = "tvRepayment")
    public AndroidElement tv_repayment;
    @AndroidFindBy(id = "tvInterestOnly")
    public AndroidElement tv_InterestOnly;
}
