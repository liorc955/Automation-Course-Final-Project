package sanity;
import extensions.MobileActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlow;

@Listeners(utilities.Listeners.class)
public class MortgageMobile extends CommonOps {


    @AfterMethod
    public void afterMethod(){
        MobileFlow.emptySavedMortgage();
    }

    @Test(description = "Test01 - Verify Failure Mortgage Calculation Repayment")
    @Description("This test fill in mortgage fields without term field and fail to calculate repayment by not giving the Repayment result")
    public void test01_verifyFailedMortgageCalculation(){
        MobileFlow.calculateMortgage("1000","","5");
        Verifications.verifyTextInElement(mortgageMain.tv_repayment, "");
    }

   @Test(description = "Test02 - Verify Mortgage Calculation Repayment")
    @Description("This test fill in mortgage fields and calculate repayment")
    public void test02_verifyMortgageCalculation(){
        MobileFlow.calculateMortgage("1000","3","5");
        Verifications.verifyTextInElement(mortgageMain.tv_repayment, "£30.60");
    }

    @Test(description = "Test03 - Verify Save Mortgage Calculation Repayment")
    @Description("This test fill in mortgage fields, calculate repayment and saves it")
    public void test03_verifySavedMortgageCalculation(){
        MobileFlow.calculateAndSaveMortgage("1000","3","5");
        MobileActions.swipe(MobileActions.Direction.LEFT);
        Verifications.verifyNumber(mortgageSaved.saved_mortgage_list.size(),1);
    }

    @Test(description = "Test04 - Verify Remove Saved Mortgage Calculation Repayment")
    @Description("This test verifies removing of saved mortgage")
    public void test04_verifyRemovingSavedMortgageCalculation(){
        MobileFlow.calculateAndSaveMortgage("10","2","8");
        MobileActions.swipe(MobileActions.Direction.LEFT);
        MobileFlow.removeFirstSavedMortgage();
        Verifications.verifyNumber(mortgageSaved.saved_mortgage_list.size(),0);
    }

    @Test(description = "Test05 - Verify Saving Multiple Mortgage Calculation Repayment")
    @Description("This test verifies saving of multiple mortgage")
    public void test05_verifySavingMortgageCalculation(){
        MobileFlow.calculateAndSaveMortgage("10","2","8");
        MobileFlow.calculateAndSaveMortgage("20","5","11");
        MobileFlow.calculateAndSaveMortgage("40","6","7");
        MobileActions.swipe(MobileActions.Direction.LEFT);
        Verifications.verifyNumber(mortgageSaved.saved_mortgage_list.size(),3);
    }

}
