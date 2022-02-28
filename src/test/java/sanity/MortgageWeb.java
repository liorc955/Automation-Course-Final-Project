package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlow;

@Listeners(utilities.Listeners.class)
public class MortgageWeb extends CommonOps {

    @Test(description = "Test01 - Verify Mortgage")
    @Description("This test fill in mortgage fields and calculate repayment")
    public void test01_verifyMortgageCalculation(){
        MobileFlow.calculateMortgage("1000","3","5");
        Verifications.verifyTextInElement(mortgageMain.tv_repayment, "£30.60");
    }



}
