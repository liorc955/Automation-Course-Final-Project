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

    @Test(description = "Test02 - Verify Subtraction Of Two Numbers")
    @Description("This test verifies Subtraction of two numbers")
    public void test02_subtractTwoNumbers(){
        DesktopFlows.subtract(5,1);
        Verifications.verifyNumber(DesktopFlows.getResult(),4);
    }

    @Test(description = "Test03 - Verify Multiplication Of Two Numbers")
    @Description("This test verifies Multiplication of two numbers")
    public void test03_multiplyTwoNumbers(){
        DesktopFlows.multiply(5,5);
        Verifications.verifyNumber(DesktopFlows.getResult(),25);
    }

    @Test(description = "Test04 - Verify Divination Of Two Numbers")
    @Description("This test verifies Divination of two numbers")
    public void test04_divideTwoNumbers(){
        DesktopFlows.divide(4,2);
        Verifications.verifyNumber(DesktopFlows.getResult(),2);
    }
}
