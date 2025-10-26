package selenium.base.driver;

import org.openqa.selenium.WebDriver;


public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void setDriver(String browserType) {
        WebDriver driver = DriverFactory.createDriver(browserType);

        driver.manage().window().maximize();

        driverThreadLocal.set(driver);
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();

        if (driver != null) {
            driver.quit(); // Close browser instance
            driverThreadLocal.remove(); //Clear ThreadLocal
        }
    }
}