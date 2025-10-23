package agest.base.element;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * Represents a text input field or textarea.
 * Extends BaseElement and adds specific methods like sendKeys.
 */
public class TextInput extends BaseElement {

    /**
     * Constructor for TextInput.
     * @param driver The WebDriver instance.
     * @param element The raw WebElement found by @FindBy.
     */
    public TextInput(WebDriver driver, WebElement element) {
        // Calls the constructor of the parent class (BaseElement)
        super(driver, element);
    }

    /**
     * Waits for the element to be visible, clears it, and sends keys.
     * @param text The text to type into the input field.
     */
    public void sendKeys(String text) {
        // The wait logic is built-in
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(this.element));

        // Good practice: always clear before typing
        visibleElement.clear();
        visibleElement.sendKeys(text);
    }

    /**
     * Simulates pressing the Enter key on the input field.
     */
    public void submit() {
        // No need to wait, just perform the action on the element
        this.element.sendKeys(Keys.ENTER);
    }
}
