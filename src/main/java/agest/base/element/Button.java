package agest.base.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement{

    /**
     * Constructor for the BaseElement.
     *
     * @param driver  The WebDriver instance.
     * @param element The raw WebElement found by @FindBy.
     */
    public Button(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    /**
     * Simulates click on button.
     */
    @Override
    public void click() {
        super.click();
    }
}
