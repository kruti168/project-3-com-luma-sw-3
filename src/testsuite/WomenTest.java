package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utilities {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException{

        // Mouse Hover on Women Menu
        WebElement women = mouseHover(By.xpath("//span[text()='Women']"));

        //Mouse Hover on Tops
        WebElement Tops = mouseHover(By.xpath("//span[text()='Tops']"));

        // Click on Jackets
        WebElement jackets = mouseHover(By.xpath("//a[@id='ui-id-11']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(women).moveToElement(Tops).moveToElement(jackets).click().build().perform();

        //* Select Sort By filter “Product Name
        WebElement productName = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"));
        Select select = new Select(productName);
        select.selectByVisibleText("Product Name");

        // Verify the products name display in alphabetical order
        // Get the names of all the products
        List<WebElement> productNames = BaseTest.driver.findElements(By.cssSelector(".product-name a"));
        List<String> actualProductNames = new java.util.ArrayList<String>();
        for (WebElement productName1 : productNames) {
            actualProductNames.add(productName.getText());
        }
        // Verify that the product names are in alphabetical order
        List<String> expectedProductNames = new java.util.ArrayList<String>(actualProductNames);
        java.util.Collections.sort(expectedProductNames);
        Assert.assertEquals(actualProductNames, expectedProductNames);
        Thread.sleep(2000);

    }
    @Test
    public void verifyTheSortByPriceFilter()throws InterruptedException{
        // Mouse Hover on Women Menu
        WebElement women = mouseHover(By.xpath("//span[text()='Women']"));

        //Mouse Hover on Tops
        WebElement Tops = mouseHover(By.xpath("//span[text()='Tops']"));

        // Click on Jackets
        WebElement jackets = mouseHover(By.xpath("//a[@id='ui-id-11']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(women).moveToElement(Tops).moveToElement(jackets).click().build().perform();
        //Select Sort By filter “Price”
        WebElement price = driver.findElement(By.xpath("//body/div[1]/main[1]/div[3]/div[1]/div[2]/div[3]/select[1]"));
        Select select1 = new Select(price);
        select1.selectByVisibleText("Price");

        //Verify the products price display in Low To High
        List<WebElement> productPrices = driver.findElements(By.xpath("//div[@class='product-info']//span[@class='price']"));
        List<Double> prices = new ArrayList<Double>();
        for (WebElement productPrice : productPrices) {
            prices.add(Double.parseDouble(productPrice.getText().replaceAll("[^0-9.]", "")));
        }
        List<Double> sortedPrices = new ArrayList<Double>(prices);
        Collections.sort(sortedPrices);
        Assert.assertEquals(prices, sortedPrices);
        Thread.sleep(2000);



    }
    @After
    public void tearDown(){
        driver.close();
    }

}