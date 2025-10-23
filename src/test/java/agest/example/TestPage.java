package agest.example;

import agest.BaseTest;
import agest.base.DriverManager;
import agest.pages.Google.GoogleHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPage extends BaseTest{
    GoogleHomePage googleHomePage;
    @Test
    public void test_VerifyGoogleSearch() throws InterruptedException {

        // 1. Get the driver from BaseTest
        WebDriver driver = DriverManager.getDriver();

        // 2. Initialize the Page Object
        // This passes the driver to the page's constructor
        googleHomePage = new GoogleHomePage(driver);

        // 3. Call Page Object methods - NOT driver.get()
        googleHomePage.navigateTo();
        googleHomePage.searchFor("Selenium WebDriver");

        Thread.sleep(1000); // Wait for results to load

        // 4. Get result and assert
        String actualTitle = googleHomePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains("Selenium WebDriver"), "Page title does not match!");

        System.out.println("Page title is: " + actualTitle);
    }
}
