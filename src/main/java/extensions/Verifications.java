package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement element, String expectedString){
        wait.until(ExpectedConditions.visibilityOf(element));
        assertEquals(element.getText(), expectedString);
    }
    @Step("Verify Number Of Elements")
    public static void verifyNumberOfElements(List<WebElement> elements, int expectedNumber){
        wait.until(ExpectedConditions.visibilityOf(elements.get(elements.size()-1)));
        assertEquals(elements.size(), expectedNumber);
    }

    @Step("Verify Visibility Of Elements")
    public static void verifyElementsDisplay(List<WebElement> elements){
        for (WebElement element : elements){
            softAssert.assertTrue(element.isDisplayed(),element.getText() + "not Displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    @Step("Verify Price Of Items After Low to High Sorting")
    public static void verifyItemsPriceAfterLowToHighSorting(List<WebElement> elements){
            double minItemPrice = Double.parseDouble(elements.get(0).getText().replace("$",""));
            for (int i = 1; i < elements.size(); i++) {
                double priceOfItem = Double.parseDouble(elements.get(i).getText().replace("$",""));
                assertTrue(priceOfItem >= minItemPrice);
                minItemPrice = priceOfItem;
            }
    }

    @Step("Verify Element Visualization")
    public static void visualElement(String expectedImageName){
        Pattern imagePattern = new Pattern(System.getProperty("user.dir") + getData("ImageRepo") + expectedImageName + ".png");
        try {
            screen.wait(imagePattern,Long.parseLong(getData("SikuliTimeOut")));
            screen.find(imagePattern);
        } catch (FindFailed findFailed) {
            fail("Error comparing image file " + findFailed);
        }
    }

    @Step("Verify Element Exists In List Of Elements By Title")
    public static  void verifyElementExistsInElementsByTitle(List<WebElement> elements, String name){
        assertTrue(UIActions.getIndexOfElementByTitle(name,elements) != -1);
    }

    @Step("Verify Element Displayed")
    public static void existenceOfElement(List<WebElement> elements){
        assertTrue(elements.size() > 0);
    }

    @Step("Verify Element Not Displayed")
    public static void nonExistenceOfElement(List<WebElement> elements){
        assertFalse(elements.size() > 0);
    }


}
