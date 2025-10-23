package agest.pages.Google;

import agest.pages.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

// 1. Make the class extend BasePage
public class GoogleHomePage extends BasePage {

    // 2. Define the Locators using @FindBy
    // This finds the element with name="q"
    @FindBy(name = "q")
    private WebElement searchBox;

    // You could also add the search button
    // @FindBy(name = "btnK")
    // private WebElement searchButton;

    // 3. Constructor: Must match the BasePage constructor
    public GoogleHomePage(WebDriver driver) {
        // 'super(driver)' calls the constructor of the parent class (BasePage)
        super(driver);
    }

    // 4. Page Action Methods: Public methods that the test case can call

    /**
     * Navigates to the Google homepage.
     */
    public void navigateTo() {
        driver.get("https://www.google.com");
    }

    /**
     * Enters a search term into the search box and submits.
     * @param text The text to search for.
     */
    public void searchFor(String text) {
        // We can now use 'searchBox' directly
        searchBox.sendKeys(text);
        searchBox.sendKeys(Keys.ENTER); // Simulate pressing Enter
    }

    /**
     * Gets the title of the current page.
     * @return The page title as a String.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
}
