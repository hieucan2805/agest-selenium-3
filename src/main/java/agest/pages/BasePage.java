package agest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    // We don't need ElementUtils anymore
    // protected ElementUtils elementUtils;

    // We can add a wait object here for page-level waits
    protected WebDriverWait pageWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.pageWait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Default 10s

        PageFactory.initElements(driver, this);
    }

    /**
     * Waits for the page title to contain a specific text.
     * @param titleSubstring The text to be present in the title.
     */
    public void waitForTitleContains(String titleSubstring) {
        pageWait.until(ExpectedConditions.titleContains(titleSubstring));
    }

    /**
     * Waits for the search result page title to appear.
     * @param searchTerm The term we searched for.
     */
    public void waitForSearchResultPage(String searchTerm) {
        // This calls the wait method from BasePage
        waitForTitleContains(searchTerm);
    }
}
