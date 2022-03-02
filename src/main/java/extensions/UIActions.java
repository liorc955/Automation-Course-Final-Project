package extensions;


import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step("Click on Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Update text Element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        clearText(elem);
        elem.sendKeys(text);
    }

    @Step("Insert Key")
    public static void insertKey(WebElement elem, Keys key){
        elem.sendKeys(key);
    }

    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, String optionName, String selectBy){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select select = new Select(elem);
        if (selectBy.equals("text")) select.selectByVisibleText(optionName);
        else if (selectBy.equals("value")) select.selectByValue(optionName);
    }

    @Step("Update text as Human")
    public static void updateTextHuman(WebElement element, String text){
        for (char ch: text.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MICROSECONDS);
            element.sendKeys(ch+"");
        }
    }


    @Step("Clear text Element")
    public static void clearText(WebElement elem){
        elem.clear();
    }

    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1, WebElement elem2){
        actions.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem){
        actions.moveToElement(elem).click().build().perform();
    }

    @Step("Get Index Of Element In Elements List By Title")
    public static int getIndexOfElementByTitle(String name, List<WebElement> elements){
        for (int i=0; i<elements.size(); i++){
            if (elements.get(i).getText().equalsIgnoreCase(name)) return i;
        }
        return -1;
    }

    @Step("Get Text Of Element")
    public static String getElementText(WebElement element){
        return element.getText();
    }

}
