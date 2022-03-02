package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;


@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01 - Verify Addition Of Two Numbers")
    @Description("This test verifies addition of two numbers")
    public void test01_addTwoNumbers(){
        DesktopFlows.sum(5,1);
        Verifications.verifyNumber(DesktopFlows.getResult(),6);
    }

    @Test(description = "Test01 - Verify Subtraction Of Two Numbers")
    @Description("This test verifies Subtraction of two numbers")
    public void test01_subtractTwoNumbers(){
        DesktopFlows.subtract(5,1);
        Verifications.verifyNumber(DesktopFlows.getResult(),4);
    }
}
