package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utilities;

public class GearTest extends Utilities {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);

    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart()throws InterruptedException {
        // Mouse Hover on Gear Menu
        WebElement gear = mouseHover(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/ul[1]/li[4]/a[1]/span[2]"));

        //Click on Bags
        WebElement bags = mouseHover(By.xpath("//a[@id='ui-id-25']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(gear).moveToElement(bags).click().build().perform();

        //* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[3]/ol[1]/li[2]/div[1]/a[1]/span[1]/span[1]/img[1]"));

        // Verify the text ‘Overnight Duffle’
        String expectedMessage = "Overnight Duffle";
        String actualMessage = getTextFromElement(By.xpath("//span[contains(text(),'Overnight Duffle')]"));
        Assert.assertEquals(expectedMessage, actualMessage);

        // Change Qty 3
        clearQty(By.xpath("//input[@id='qty']"));
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");

        // Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //Verify the text‘You added Overnight Duffle to your shopping cart.’
        String expectedMessage1 = "You added Overnight Duffle to your shopping cart.";
        String actualMessage1 = getTextFromElement(By.xpath("//body/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
        Assert.assertEquals(expectedMessage1, actualMessage1);

        // Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        // Verify the Qty is ‘3’
        //  String expectedMessage2 = "3";
        //  String actualMessage2 =getTextFromElement(By.xpath("//input[@id='qty']"));
        //  Assert.assertEquals(expectedMessage2,actualMessage2);

        // Verify the product price ‘$135.00’
        String expectedMessage3 = "$135.00";
        String actualMessage3 = getTextFromElement(By.xpath("//tbody/tr[1]/td[4]/span[1]/span[1]/span[1]"));
        Assert.assertEquals(expectedMessage3, actualMessage3);
        
        //Change Qty to ‘5’
        mouseHover(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/label[1]"));
        clickOnElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/label[1]"));
        clearQty(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/label[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[3]/div[1]/div[1]/label[1]"), "5");
        Thread.sleep(2000);


        //Click on ‘Update Shopping Cart’ button
        mouseHover(By.xpath("//span[normalize-space()='Update Shopping Cart']")).click();

        //Verify the product price ‘$225.00’
        String expectedTotal2 = "$225.00";
        String actualTotal2 = getTextFromElement(By.xpath("/html[1]/body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/span[1]/span[1]/span[1]"));
        Assert.assertEquals(expectedTotal2, actualTotal2);
        Thread.sleep(2000);

    }



    @After
    public void tearDown(){

       // closeBrowser();
    }
}
