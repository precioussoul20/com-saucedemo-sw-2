package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    static String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() throws InterruptedException {
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(5000);
        //Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(5000);
        //Click on login Button
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        //Verify the Text
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.xpath("//span[@class='title']")).getText();
        Assert.assertEquals(expectedText, actualText);


    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(5000);
        //Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        Thread.sleep(5000);
        //Click on login Button
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(5000);
        //Verify that six products are displayed on page.
        List<WebElement>productsDisplayed=driver.findElements(By.className("inventory_item"));
        int number = productsDisplayed.size();
        System.out.println("Number of products displayed in the page " + number);









    }







    @After
    public void tearDown(){
        closeBrowser();
    }
}
