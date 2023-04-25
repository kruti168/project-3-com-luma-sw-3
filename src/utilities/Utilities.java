package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Utilities extends BaseTest {

    //This method will hoover element
    public WebElement mouseHover(By by){

        return driver.findElement(by);
    }
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();

    }
    //This method click on the menu
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    //This method will be clear the qty.
    public void clearQty(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
}
    //This method will send text to element
    public void sendTextToElement(By by,String text) {
        driver.findElement(by).sendKeys(text);
    }

}
