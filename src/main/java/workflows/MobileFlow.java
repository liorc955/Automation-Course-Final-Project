package workflows;

import extensions.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlow extends CommonOps {

    @Step("Business Flow: Fill Form and Calculate Mortgage")
    public static void calculateMortgage(String amount, String term, String rate){
        MobileActions.updateText(mortgageMain.txt_amount, amount);
        MobileActions.updateText(mortgageMain.txt_term,term);
        MobileActions.updateText(mortgageMain.txt_rate,rate);
        MobileActions.tap(mortgageMain.btn_calculate);
    }

    @Step("Business Flow: Fill Form, Calculate Mortgage and Saved it")
    public static void calculateAndSaveMortgage(String amount, String term, String rate){
        MobileFlow.calculateMortgage(amount,term,rate);
        MobileActions.tap(mortgageMain.btn_save);
    }

    @Step("Business Flow: Remove All Saved Mortgage Calculations")
    public static void emptySavedMortgage(){
        MobileActions.swipe(MobileActions.Direction.LEFT);
        int sizeOfSavedMortgages = mortgageSaved.saved_mortgage_list.size();
        if (sizeOfSavedMortgages > 0)
            for (int i=0; i<sizeOfSavedMortgages; i++){
                removeFirstSavedMortgage();
            }
        MobileActions.swipe(MobileActions.Direction.RIGHT);
    }

    @Step("Business Flow: Remove First Saved Mortgage")
    public static void removeFirstSavedMortgage(){
        MobileActions.tap(mortgageSaved.btn_delete_saved_mortgage);
        MobileActions.tap(mortgageSaved.btn_accept_alert);
    }


}
