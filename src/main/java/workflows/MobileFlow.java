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
}
