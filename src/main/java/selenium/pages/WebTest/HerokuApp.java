package selenium.pages.WebTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import selenium.base.element.Button;
import selenium.base.element.TextInput;
import selenium.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.utils.ConfigReader;

// 1. Make the class extend BasePage
public class HerokuApp extends BasePage {
    private static final Logger log = LogManager.getLogger(HerokuApp.class);

    @FindBy(name = "q")
    private WebElement searchBox_raw; // We name it '_raw' to be clear

    @FindBy(name = "btnK")
    private WebElement searchButton_raw;

    public HerokuApp(WebDriver driver) {
        super(driver);
    }

    public TextInput getSearchBox() {
        return new TextInput(this.driver, searchBox_raw);
    }

    public Button searchButton() {
        return new Button(this.driver, searchButton_raw);
    }


    // --- Page Action Methods ---

    public void navigateTo() {
        String url = ConfigReader.getProperty("url.webtest");
        log.info("Navigating to URL: {}", url);
        driver.get(url);    }

    /**
     * Performs a search using the smart TextInput element.
     *
     * @param text The text to search for.
     */
    public void searchFor(String text) {
        log.info("Performing search for text: '{}'", text);
        getSearchBox().sendKeys(text);
        getSearchBox().submit();

        searchButton().click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
