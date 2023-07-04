package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilites.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser();

    }

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        //* Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //* Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //* Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals("Products text not found.", expectedText, actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        // Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");

        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));


        //Verify that six products are displayed on page
        List<WebElement> products = driver.findElements(By.xpath("//img[@class='inventory_item_img']"));
        System.out.println("Total products on the page is : " + products.size());


    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


}
