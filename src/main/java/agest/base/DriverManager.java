package agest.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

    // 1. Define ThreadLocal
    // Nó sẽ lưu trữ đối tượng WebDriver cho từng luồng riêng biệt.
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // 2. Phương thức getDriver()
    // Dùng để lấy ra WebDriver từ ngăn tủ ThreadLocal.
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    // 3. Phương thức setDriver()
    // Đây là "Browser Factory"
    public static void setDriver(String browserType) {
        WebDriver driver;

        // Dùng switch-case để chọn trình duyệt
        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                // Trường hợp mặc định nếu gõ sai tên
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                System.out.println("Browser type " + browserType + " is not recognized. Defaulting to Chrome.");
                break;
        }

        // Tối đa hóa cửa sổ trình duyệt (thường làm ở đây)
        driver.manage().window().maximize();

        // Cất WebDriver vào ngăn tủ ThreadLocal
        driverThreadLocal.set(driver);
    }

    // 4. Phương thức quitDriver()
    // Dùng để đóng trình duyệt và dọn dẹp ThreadLocal
    public static void quitDriver() {
        // Lấy driver từ ThreadLocal
        WebDriver driver = driverThreadLocal.get();

        if (driver != null) {
            driver.quit(); // Đóng trình duyệt
            driverThreadLocal.remove(); // Dọn dẹp ngăn tủ, rất quan trọng!
        }
    }
}