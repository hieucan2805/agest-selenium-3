package selenium.example;

import selenium.BaseTest;
import selenium.base.driver.DriverManager;
import selenium.pages.WebTest.HerokuApp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPage extends BaseTest{
    HerokuApp googleHomePage;

    @Test
    public void test_VerifyGoogleSearch() {

        WebDriver driver = DriverManager.getDriver();
        googleHomePage = new HerokuApp(driver);

        String searchTerm = "Selenium WebDriver";

        // --- Test Steps ---
        // These steps are now extremely readable
        googleHomePage.navigateTo();

        // This single line does: wait, clear, sendkeys, and submit
        googleHomePage.searchFor(searchTerm);

        // This replaces Thread.sleep()
        googleHomePage.waitForSearchResultPage(searchTerm);

        // --- Assertion ---
        String actualTitle = googleHomePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(searchTerm), "Page title does not match!");
        System.out.println("Page title is: " + actualTitle);
    }
}
