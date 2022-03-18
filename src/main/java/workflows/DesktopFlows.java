package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    private static WebElement getNumberElement(int number){
        switch (number){
            case 1: return calcMain.btn_one;
            case 2: return calcMain.btn_two;
            case 3: return calcMain.btn_three;
            case 4: return calcMain.btn_four;
            case 5: return calcMain.btn_five;
            default: throw new RuntimeException("Invalid number");
        }
    }
    @Step("Business Flow: Sum Two Numbers")
    public static void sum(int numOne, int numTwo){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(getNumberElement(numOne));
        UIActions.click(calcMain.btn_plus);
        UIActions.click(getNumberElement(numTwo));
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Business Flow: Subtract Two Numbers")
    public static void subtract(int numOne, int numTwo){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(getNumberElement(numOne));
        UIActions.click(calcMain.btn_minus);
        UIActions.click(getNumberElement(numTwo));
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Business Flow: Multiply Two Numbers")
    public static void multiply(int numOne, int numTwo){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(getNumberElement(numOne));
        UIActions.click(calcMain.btn_multiply);
        UIActions.click(getNumberElement(numTwo));
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Business Flow: Divide Two Numbers")
    public static void divide(int numOne, int numTwo){
        UIActions.click(calcMain.btn_clear);
        UIActions.click(getNumberElement(numOne));
        UIActions.click(calcMain.btn_divide);
        UIActions.click(getNumberElement(numTwo));
        UIActions.click(calcMain.btn_equals);
    }

    @Step("Business Flow: Get Calculator Result")
    public static int getResult(){
        int resultNumber = Integer.parseInt(UIActions
                .getElementText(calcMain.field_result)
                .replace("Display is ","")
                .trim());
        return resultNumber;
    }
}
