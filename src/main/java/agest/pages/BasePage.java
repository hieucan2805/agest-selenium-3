package agest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver; // 'protected' so child classes can access it

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;

        // This line initializes all @FindBy elements in the Page Class
        PageFactory.initElements(driver, this);
    }
}
