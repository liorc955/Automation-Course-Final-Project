package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)
public class SauceDemoDB extends CommonOps {

    @Test(description = "Test01 - Login to SauceDemo with DB Credentials")
    @Description("This test login with DB credentials and verifies the header")
    public void test01_verifyTitle(){
        WebFlows.loginWithDB(2);
        Verifications.verifyTextInElement(sauceDemoSecondaryHeader.header_secondary_title, "PRODUCTS");
    }
}
