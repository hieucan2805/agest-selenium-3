package agest.base.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for all custom element wrappers.
 * It contains the core WebElement and the WebDriver.
 * It also includes built-in Explicit Waits for all basic actions.
 */
public class BaseElement {

    protected WebDriver driver;
    protected WebElement element; // The raw WebElement wrapped by this class
    protected WebDriverWait wait;

    // We can get this from a config file later
    private static final int DEFAULT_TIMEOUT_SECONDS = 10;

    /**
     * Constructor for the BaseElement.
     * @param driver The WebDriver instance.
     * @param element The raw WebElement found by @FindBy.
     */
    public BaseElement(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
        // Initialize the wait object for this element
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
    }

    /**
     * Waits for the element to be clickable, then clicks it.
     */
    public void click() {
        // The wait is built-in!
        wait.until(ExpectedConditions.elementToBeClickable(this.element)).click();
    }

    /**
     * Waits for the element to be visible, then gets its text.
     * @return The text of the element.
     */
    public String getText() {
        return wait.until(ExpectedConditions.visibilityOf(this.element)).getText();
    }

    /**
     * Checks if the element is visible.
     * Includes a wait to give the element time to appear.
     * @return true if visible, false otherwise.
     */
    public boolean isDisplayed() {
        try {
            // Wait for visibility and return its display status
            return wait.until(ExpectedConditions.visibilityOf(this.element)).isDisplayed();
        } catch (Exception e) {
            // If it's not visible after the timeout, catch exception and return false
            return false;
        }
    }

    /**
     * Gets the raw, underlying WebElement.
     * (Useful for advanced interactions not covered here)
     * @return The WebElement.
     */
    public WebElement getRawElement() {
        return this.element;
    }
}
