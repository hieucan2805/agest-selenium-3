package agest;

import agest.base.driver.DriverManager;
import agest.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    // BEFORE each and every @Test method.
    @Parameters("browser")
    @BeforeMethod
    public void setupTest(@Optional String browser) {

        String browserToUse;

        // 2. Logic to decide which browser to use
        if (browser == null || browser.isEmpty()) {
            // If 'browser' parameter is not provided by testng.xml
            browserToUse = ConfigReader.getProperty("browser");
        } else {
            // If 'browser' parameter IS provided by testng.xml
            browserToUse = browser;
        }

        // 3. Set the driver using the final value
        DriverManager.setDriver(browserToUse);
        System.out.println("Opening browser: " + browserToUse);
    }

    // This annotation tells TestNG to run this method
    // AFTER each and every @Test method.
    @AfterMethod
    public void teardownTest() {
        // We close the browser here
        // This ensures the browser is closed even if the test fails.
        DriverManager.quitDriver();
    }
}
