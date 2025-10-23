package agest;

import agest.base.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    // BEFORE each and every @Test method.
    @Parameters("browser")
    @BeforeMethod
    public void setupTest(@Optional("chrome") String browser) {
        // We initialize the browser here
        DriverManager.setDriver(browser);
        System.out.println("Opening browser: " + browser);
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
